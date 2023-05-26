package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.empty.search;

import java.util.List;

public interface UserService {
    /*
    * 通过账号密码登录
    * */
    public User findUser(String username, String password);
//注册添加用户
    public int comport(String username);
    public  void addUser(String username, String password,String power);
    public User findUserAndPassByname(String username);
    public int updatePass(String username, String password);


    public List<User> findUserWithPaging(search search);
    public int findUserWithPagingCount(String search);

    //管理员删除用户
    public int deleteUserById(int id);


    //管理员更新用户
    public int updateUser(User user);

    public int updateUserPowerByUserName(String username, String power);
}
