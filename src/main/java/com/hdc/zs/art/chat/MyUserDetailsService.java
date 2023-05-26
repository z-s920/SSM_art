package com.hdc.zs.art.chat;


import com.hdc.zs.art.dao.UserDao;
import com.hdc.zs.art.empty.Journalism;
import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 用户登录  并且赋予权限
 * Created by DELL(zs) on 2021/1/22 21:30
 */
@Service("userDatailsService")
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private JournalismService journalismService;


    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException , InternalAuthenticationServiceException {

        // 获取session
        HttpSession session = httpServletRequest.getSession();

        // 根据 用户name查详细信息
        User user = userDao.findUserByUSerName(username);

        // 若结果不为空 则进行 权限授予
        if (user == null){
            System.out.println("用户不存在");
            return new org.springframework.security.core.userdetails.User("error",new BCryptPasswordEncoder().encode("error"),AuthorityUtils.commaSeparatedStringToAuthorityList("无用户权限"));
        }
        List<Journalism> news = journalismService.findNews();
        // 将用户name 存 session
        session.setAttribute("username", user.getUsername());
        session.setAttribute("news",news);

        // 生成角色权限
        String auth = "ROLE_"+ user.getPower();

        // 记录该角色的权限
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList(auth);

        // 验证密码是否正确。  这里进行登录判断   若 密码错误则返回首页
        return new org.springframework.security.core.userdetails.User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),auths);

    }
}
