package com.gwtjs.icustom.security.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.security.bean.SysPermissionVO;
import com.gwtjs.icustom.security.bean.SysRoleVO;
import com.gwtjs.icustom.security.bean.SysUserVO;
import com.gwtjs.icustom.security.service.SecurityDataService;

/**
 * 提供用户信息封装服务
 * 
 * @author aGuang
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	SecurityDataService securityDataService;

	/**
	 * 根据用户输入的用户名返回数据源中用户信息的封装，返回一个UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUserVO sysUserVO = securityDataService.findSUserByName(username);
		// 用户角色列表
		List<SysRoleVO> sRoleList = securityDataService.findSRoleListBySUserId(sysUserVO.getId());
		// 用户资源权限列表
		List<SysPermissionVO> sPermissionList = securityDataService.findSPermissionListBySUserId(sysUserVO.getId());
		return new MyUserDetails(sysUserVO, sRoleList, sPermissionList);
	}

}
