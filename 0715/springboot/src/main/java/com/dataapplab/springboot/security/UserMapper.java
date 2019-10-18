package com.dataapplab.springboot.security;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO USER(user_id,user_name,email,password) VALUES(#{userId},#{userName},#{email},#{password})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Account user);
	
    @Update("UPDATE USER SET user_name=#{userName},avatar=#{avatar}, email=#{email},password=#{password} "
    		+ " WHERE user_id=#{userId}")
    int updateUser(Account user);

    @Delete("DELETE FROM `user` WHERE `user_id`=#{id};")
    int delete(int id);
	
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
	
	@Select({
		"SELECT u.*, ur.role_id, r.name, r.description from",
		"(SELECT * FROM user WHERE email=#{emailorUserName} or user_name=#{emailorUserName} LIMIT 1) u",
		"left join user_role ur on u.user_id = ur.user_id",
		"left join role r on ur.role_id = r.role_id"
	})
	@ResultMap("com.dataapplab.springboot.security.UserMapper.UserResultWithRoles")	
	Account getUserByNameorEmail(String emailorUserName);
}
