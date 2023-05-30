package com.library.mapper;

import com.library.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where uname = #{username} and upassword = #{password}")
    User select(String username, String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from user where uno = #{username}")
    User selectByUsername(String username,String password);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user values(#{uno},#{username},#{sex},#{password},#{email})")
    void add(User user);
}
