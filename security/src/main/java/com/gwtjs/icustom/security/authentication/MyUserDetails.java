package com.gwtjs.icustom.security.authentication;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.gson.Gson;
import com.gwtjs.icustom.security.bean.SysPermissionVO;
import com.gwtjs.icustom.security.bean.SysRoleVO;
import com.gwtjs.icustom.security.bean.SysUserVO;

/**
 * 用户信息的封装，包含用户名称密码及用户状态、权限等信息
 * 
 * @author aGuang
 */
public class MyUserDetails extends SysUserVO implements UserDetails {

	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	// 用户角色列表
	private List<SysRoleVO> sRoleList = null;
	// 用户资源权限列表
	private List<SysPermissionVO> sysPermissionList = null;

	/**
	 * 注意后边的这两个参数：sRoleList、sPermissionList
	 * 
	 * @param sysUserVO
	 * @param sRoleList
	 * @param sPermissionList
	 */
	public MyUserDetails(SysUserVO sysUserVO, List<SysRoleVO> sRoleList, List<SysPermissionVO> sysPermissionList) {
		super(sysUserVO);
		this.sRoleList = sRoleList;
		this.sysPermissionList = sysPermissionList;
	}

	/**
	 * 获取用户权限列表方法 可以理解成，返回了一个List<String>，之后所谓的权限控制、鉴权，其实就是跟这个list里的String进行对比
	 * 这里处理了角色和资源权限两个列表，可以这么理解， 角色是权限的抽象集合，是为了更方便的控制和分配权限，而真正颗粒化细节方面，还是需要资源权限自己来做
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		StringBuilder authoritiesBuilder = new StringBuilder("");
		List<SysRoleVO> tempRoleList = this.getsRoleList();
		if (null != tempRoleList) {
			for (SysRoleVO role : tempRoleList) {
				authoritiesBuilder.append(",").append(role.getRole());
			}
		}
		List<SysPermissionVO> tempPermissionList = this.getSysPermissionList();
		if (null != tempPermissionList) {
			for (SysPermissionVO permission : tempPermissionList) {
				authoritiesBuilder.append(",").append(permission.getPermission());
			}
		}
		String authoritiesStr = "";
		if (authoritiesBuilder.length() > 0) {
			authoritiesStr = authoritiesBuilder.deleteCharAt(0).toString();
		}
		logger.info("MyUserDetails getAuthorities [authoritiesStr={} ", authoritiesStr);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesStr);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	/**
	 * 判断账号是否已经过期，默认没有过期
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 判断账号是否被锁定，默认没有锁定
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 判断信用凭证是否过期，默认没有过期
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 判断账号是否可用，默认可用
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<SysRoleVO> getsRoleList() {
		return sRoleList;
	}

	public void setsRoleList(List<SysRoleVO> sRoleList) {
		this.sRoleList = sRoleList;
	}

	public List<SysPermissionVO> getSysPermissionList() {
		return sysPermissionList;
	}

	public void setSysPermissionList(List<SysPermissionVO> sysPermissionList) {
		this.sysPermissionList = sysPermissionList;
	}

}
