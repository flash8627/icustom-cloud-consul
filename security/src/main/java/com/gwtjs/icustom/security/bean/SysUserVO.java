package com.gwtjs.icustom.security.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户名密码信息
 * 
 * @author aGuang
 */
/*maven编译不通过
 * @Data
@NoArgsConstructor
@AllArgsConstructor*/
public class SysUserVO {
	
	private int id;
	private String name;
	private String password;
	
	public SysUserVO() {
		
	}

	public SysUserVO(SysUserVO sysUserVO) {
		this.id = sysUserVO.getId();
		this.name = sysUserVO.getName();
		this.password = sysUserVO.getPassword();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
