package com.gwtjs.icustom.security.authorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.gwtjs.icustom.security.bean.SysPermissionVO;
import com.gwtjs.icustom.security.bean.SysRoleVO;
import com.gwtjs.icustom.security.service.SecurityDataService;

/**
 * 权限资源管理器 根据用户请求的地址，获取访问该地址需要的所需权限
 * 
 * @author aGuang
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	Gson gson = new Gson();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SecurityDataService securityDataService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 获取请求起源路径
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		logger.info("MyFilterInvocationSecurityMetadataSource getAttributes [requestUrl={}]", requestUrl);
		// 登录页面就不需要权限
		if ("/login".equals(requestUrl)) {
			return null;
		}
		// 用来存储访问路径需要的角色或权限信息
		List<String> tempPermissionList = new ArrayList<String>();
		// 获取角色列表
		List<SysRoleVO> sRoleList = securityDataService.findSRoleListBySPermissionUrl(requestUrl);
		logger.info("MyFilterInvocationSecurityMetadataSource getAttributes [sRoleList={}]", gson.toJson(sRoleList));
		for (SysRoleVO sysRoleVO : sRoleList) {
			tempPermissionList.add(sysRoleVO.getRole());
		}
		// 径获取资源权限列表
		List<SysPermissionVO> sPermissionList = securityDataService.findSPermissionListBySPermissionUrl(requestUrl);
		logger.info("MyFilterInvocationSecurityMetadataSource getAttributes [sPermissionList={}]",
				gson.toJson(sPermissionList));
		for (SysPermissionVO sysPermissionVO : sPermissionList) {
			tempPermissionList.add(sysPermissionVO.getPermission());
		}
		// 如果没有权限控制的url，可以设置都可以访问，也可以设置默认不许访问
		if (tempPermissionList.isEmpty()) {
			return null;// 都可以访问
			// tempPermissionList.add("DEFAULT_FORBIDDEN");//默认禁止
		}
		String[] permissionArray = tempPermissionList.toArray(new String[0]);
		logger.info("MyFilterInvocationSecurityMetadataSource getAttributes [permissionArray={}]",
				gson.toJson(permissionArray));
		return SecurityConfig.createList(permissionArray);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
