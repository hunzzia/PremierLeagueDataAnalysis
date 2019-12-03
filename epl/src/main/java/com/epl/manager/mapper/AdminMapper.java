package com.epl.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.epl.manager.vo.Admin;
import com.epl.manager.vo.LoginForm;

@Mapper
public interface AdminMapper {
	public int insertAdmin(Admin admin);
	public int updateAdmin(Admin admin);
	public int updateAdminPw(Admin admin);
	Admin selectAdminOne(LoginForm loginForm);
}
