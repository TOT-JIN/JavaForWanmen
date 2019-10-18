package com.dataapplab.springboot.security;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	//Read All
	@Select("select * from user;")
	@Results({
	@Result(id=true, column="user_id", property="userId"),
	@Result(column="user_name", property="userName"),
	@Result(column="avatar", property="avatar"),
	@Result(column="email", property="email"),
	@Result(column="password", property="password"),
	})
	List<Account> getUsers();
	
	//get by user name
	@Select("select * from user where user_name=#{userName};")
	Account getUserByName(String userName);
}
