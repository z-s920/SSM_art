package com.hdc.zs.art.dao;

import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.empty.search;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    // 根据用户名查询用户信息，用于认证     // 给权限认证保留
    public User findUserByUSerName(@Param("username")String username);
    // 保留结束
    public User findUser(@Param("username")String username, @Param("password")String password);

    public  void addUser(@Param("username") String username, @Param("password")String password,@Param("power")String power);
    public Integer comport(@Param("username")String username);
    //查看个人信息
    public User findUserAndPassByname(String username);
    public int updatePass(@Param("username")String username, @Param("password")String password);


   //管理员界面用户分页
    List<User> findUserWithPaging(search search);
    int findUserWithPagingCount(String search);
    public int updateUserPowerByUserName(@Param("username")String username, @Param("power")String power);

    //管理员删除用户
    public int deleteUserById(int id);

    //管理员更新用户
    public int updateUser(User user);
}
