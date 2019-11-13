package com.gwtjs.icustom.security.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserDaoTest {
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Test
	public void testSysUserDao()
	{
		System.out.println(sysUserDao);
	}
	
}
