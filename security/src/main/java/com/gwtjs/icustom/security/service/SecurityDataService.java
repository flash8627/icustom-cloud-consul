package com.gwtjs.icustom.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.security.bean.SysPermissionVO;
import com.gwtjs.icustom.security.bean.SysRoleVO;
import com.gwtjs.icustom.security.bean.SysUserVO;
import com.gwtjs.icustom.security.dao.SysPermissionDao;
import com.gwtjs.icustom.security.dao.SysRoleDao;
import com.gwtjs.icustom.security.dao.SysUserDao;

/**
 * Security 数据服务
 * 
 * @author aGuang
 */
@Service
public class SecurityDataService {
	
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysPermissionDao sysPermissionDao;

	public SysUserVO findSUserByName(String name) {
		return sysUserDao.findSUserByName(name);
	}

	public List<SysRoleVO> findSRoleListBySUserId(int sUserId) {
		return sysRoleDao.findSRoleListBySUserId(sUserId);
	}

	public List<SysRoleVO> findSRoleListBySPermissionUrl(String sPermissionUrl) {
		return sysRoleDao.findSRoleListBySPermissionUrl(sPermissionUrl);
	}

	public List<SysPermissionVO> findSPermissionListBySUserId(int sUserId) {
		return sysPermissionDao.findSPermissionListBySUserId(sUserId);
	}

	public List<SysPermissionVO> findSPermissionListBySPermissionUrl(String sPermissionUrl) {
		return sysPermissionDao.findSPermissionListBySPermissionUrl(sPermissionUrl);
	}
}
