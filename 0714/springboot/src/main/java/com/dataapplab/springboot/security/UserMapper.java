package com.dataapplab.springboot.security;

/**
 * @Options(useGeneratedKeys=true, keyProperty="studId")
 * database server generate the auto_increment column value
 * https://github.com/obazoud/mybatis-with-annotations-spring-example/blob/master/src/com/igorbaiborodine/example/mybatis/customer/CustomerMapper.java
 * https://github.com/igor-baiborodine/java-various-examples/blob/master/mybatis-annotations-spring-example/src/main/java/com/kiroule/example/mybatis/mapper/CustomerMapper.java
 * http://js-grid.com/docs/#grid-controller
 */
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface UserMapper {

	/**
	 * for some database
	 * @SelectKey to generate the primary key value and stored it before executing the INSERT statement
	 * SEQUENCE, we can obtain the database-generated primary key value from sequence_name.currval after the INSERT statement is executed
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO USER(user_id,user_name,email,password) VALUES(#{id},#{userName},#{email},#{password})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Account user);

	@Select("SELECT user_id, user_name, email FROM user WHERE id=#{id}")
    Account getUserByID(int id);

    @Update("UPDATE USER SET user_name=#{userName},avatar=#{avatar}, email=#{email},password=#{password}, "
    		+ "reset_token =#{resetToken}, enable=#{enabled} WHERE user_id=#{id}")
    int updateUser(Account user);

    @Delete("DELETE FROM `user` WHERE `user_id`=#{id};")
    int delete(int id);
    
    
	@Select("SELECT * FROM user")
	/*@Results({
		@Result(id=true, column="user_id", property="id"),
		@Result(column="user_name", property="userName"),
		@Result(column="avatar", property="avatar"),
		@Result(column="email", property="email"),
		@Result(column="password", property="password"),
		@Result(column="reset_token", property="resetToken"),
		@Result(column="enable", property="enabled")
	})*/
	@ResultMap("com.dataapplab.springboot.security.UserMapper.UserResult")		
	List<Account> getUsers_id();
	
	@Select("SELECT * FROM user WHERE user_name=#{userName} LIMIT 1")
    Account getUserByUserName(String userName);
	
	//@Select("SELECT * FROM user WHERE email=#{emailorUserName} or user_name=#{emailorUserName} LIMIT 1")
	@Select({
		"SELECT u.*, ur.role_id, r.name, r.description from",
		"(SELECT * FROM user WHERE email=#{emailorUserName} or user_name=#{emailorUserName} LIMIT 1) u",
		"left join user_role ur on u.user_id = ur.user_id",
		"left join role r on ur.role_id = r.role_id"
	})
	@ResultMap("com.dataapplab.springboot.security.UserMapper.UserResultWithRoles")
    Account getUserByUserNameorEmail(String emailorUserName);
}








