package com.library.mapper;

import com.library.pojo.LoginOther;
import com.library.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where uname = #{username} and upassword = #{password}")
    User selectUser(@Param("username")String username, @Param("password") String password);

    /**
     * 添加用户
     * @param
     */
    @Insert("INSERT INTO user(uname,usex,upassword,email)\n" +
            "VALUES(#{username},#{sex},#{password},#{email});\n")
    void add(@Param("username")String username,@Param("password") String password,@Param("sex") String sex,@Param("email") String email);

    @Select("select * from user where uname = #{username} ")
    User select(String username);

    @Select("SELECT mname ,mpassword\n" +
            "FROM librarian;\n")
    List<LoginOther> selectLibray();

    @Select("SELECT sname,spassword\n" +
            "FROM sa;\n")
    List<LoginOther> selectSa();

    @Select("SELECT *\n" +
            "FROM user\n" +
            "WHERE uname=#{username} AND email=#{email};\n")
    User selectEmail(@Param("username")String username, @Param("email") String email);
    @Select("UPDATE user\n" +
            "SET uname=#{username},upassword=#{password}\n" +
            "WHERE uname=#{username};\n")
    void updatePsw(@Param("username")String username, @Param("password") String password);
}
