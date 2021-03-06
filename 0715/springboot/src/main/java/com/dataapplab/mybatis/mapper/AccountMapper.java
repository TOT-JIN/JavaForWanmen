package com.dataapplab.mybatis.mapper;

import com.dataapplab.mybatis.model.Account;
import com.dataapplab.mybatis.model.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @SelectProvider(type=AccountSqlProvider.class, method="countByExample")
    long countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @DeleteProvider(type=AccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @Insert({
        "insert into user (user_id, user_name, ",
        "avatar, email, password, ",
        "reset_token, enable, ",
        "create_date, modified_date)",
        "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{resetToken,jdbcType=VARCHAR}, #{enable,jdbcType=BIT}, ",
        "#{createDate,jdbcType=DATE}, #{modifiedDate,jdbcType=DATE})"
    })
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @InsertProvider(type=AccountSqlProvider.class, method="insertSelective")
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @SelectProvider(type=AccountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="reset_token", property="resetToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="modified_date", property="modifiedDate", jdbcType=JdbcType.DATE)
    })
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @Select({
        "select",
        "user_id, user_name, avatar, email, password, reset_token, enable, create_date, ",
        "modified_date",
        "from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="reset_token", property="resetToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="modified_date", property="modifiedDate", jdbcType=JdbcType.DATE)
    })
    Account selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @UpdateProvider(type=AccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sat Jul 14 15:57:32 CST 2018
     */
    @Update({
        "update user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "reset_token = #{resetToken,jdbcType=VARCHAR},",
          "enable = #{enable,jdbcType=BIT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "modified_date = #{modifiedDate,jdbcType=DATE}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);
}