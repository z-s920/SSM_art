package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.UserDao;
import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String username, String password) {
        User user=this.userDao.findUser(username, password);
        return user;
    }
//注册
    @Override
    public int comport(String username) {
        if (userDao.comport(username)==0)
        {
            return 0;
        }
        return 1;
    }
    //注册
    @Override
    public void addUser(String username, String password,String power) {
            this.userDao.addUser(username,password,power);
    }
    //注册
    @Override
    public User findUserAndPassByname(String username) {
        User user=this.userDao.findUserAndPassByname(username);
        return user;
    }
//用户修改个人密码
    @Override
    public int updatePass(String password,String username) {
        int i =this.userDao.updatePass(password,username);
        return i;
    }
//分页
    @Override
    public List<User> findUserWithPaging(search search) {
        int i = VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.userDao.findUserWithPaging(search);
    }

    @Override
    public int findUserWithPagingCount(String search) {
        int total=userDao.findUserWithPagingCount(search);
        return total;
    }

    //管理员删除用户个人信息
    @Override
    public int deleteUserById(int id) {
        return this.userDao.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return this.userDao.updateUser(user);
    }

    @Override
    public int updateUserPowerByUserName(String username, String power) {
        return userDao.updateUserPowerByUserName(username,power);
    }


    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){

        // page:              1, 2,    3,   4,   5,6,7,8,9...... 第几页，  limit : 10
        // 而数据库想要的page   0, 10 , 20 , 30
        // 怎么转换

        return (page-1)*limit;
    }
}
