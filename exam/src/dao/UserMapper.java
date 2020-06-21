package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(@Param("username")String username,@Param("password")String password);
}
