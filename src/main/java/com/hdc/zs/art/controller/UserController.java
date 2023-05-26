package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.Journalism;
import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.service.JournalismService;
import com.hdc.zs.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JournalismService journalismService;
    private int RandomUserId = 0;




    @GetMapping(value = "/error")
    public String error() {


        return "login";
    }

    //  ---------  权限框架使用  例子  只加一个注解  @Secured({"ROLE_学生","ROLE_管理员","ROLE_兴趣爱好者"})
    // ---------    每次只修改  后边汉字     对应数据库的  power 中内容
    //  ----------  不同的汉字被添加到 不同的方法上 就有不同的权限。     添加什么汉字  标志这个方法什么权限可以访问

    // 以下为 权限怎么使用 为示例 进行演示
    // 学生   和    管理员   和   兴趣爱好者        可以访问的页面
    @Secured({"ROLE_学生", "ROLE_管理员", "ROLE_兴趣爱好者"})
    @GetMapping(value = "/user/test1")
    public String test1() {
        return "test/test1";
    }

    //    管理员   和   兴趣爱好者        可以访问的页面
    @Secured({"ROLE_管理员", "ROLE_兴趣爱好者"})
    @GetMapping(value = "/user/test2")
    public String test2() {
        return "test/test2";
    }

    //    管理员         可以访问的页面
    @Secured({"ROLE_管理员"})
    @GetMapping(value = "/user/test3")
    public String test3() {
        return "test/test3";
    }

    @GetMapping(value = "/user/test4")
    public String test4() {
        return "test/test4";
    }


    // --------------------------------    以下 用作 跳转登录页  首页   客服页。  需要保留  不能删除

    // 进驻登录成功后的主页
    @GetMapping(value = "/user/home")
    public String index(Model model) {
        return "home";
    }

    // 注销登录返回登录首页
    @GetMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    // 用户的客服中心
    @GetMapping(value = "/userKeFu")
    public String userKeFu(HttpSession session) {
        session.setAttribute("customer", String.valueOf(RandomUserId++));
        return "user/kefu";
    }

    // 管理员的客服中心
    @GetMapping(value = "/adminKeFu")
    public String adminKeFu() {
        return "admin/kefu";
    }

    //注册页面的注册
    @PostMapping(value = "/register")
    public String Register(String username, String password, String power, Model model) {
        int comport = userService.comport(username);
        if (comport == 0) {
            userService.addUser(username, password, power);
            model.addAttribute("msg", "恭喜您注册成功！");
            return "login";
        }
        model.addAttribute("msg", "用户名已存在，请重新输入！");
        return "register";
    }

    //登录页面返回到注册页面
    @GetMapping(value = "/register1")
    public String register() {
        return "register";
    }

    //home页面跳转到测试留言板
    /*@GetMapping(value = "/message.action")
    public String tomessage(){
        return "message";
    }*/

 /*   @GetMapping(value = "/service")
    public String*/
 //跳转到相关资料页面
 @GetMapping(value = "/second")
    public String toSecond(){
     return "Relevant_information";
 }
 @GetMapping(value = "/about")
    public String toAbout()
 {
     return "self/about";
 }
 @GetMapping(value = "/personal")
         public String toPersonal(String username,Model model,HttpSession session)
 {
     String name = (String) session.getAttribute("username");
     User user=userService.findUserAndPassByname(name);
     model.addAttribute("user",user);
     System.out.println(user);
     return "/person";
 }
 @GetMapping(value = "/personUpdatePass")
         public String toUpdatePass(String password,String username)
 {
     System.out.println(password);
     userService.updatePass(username,password);
     System.out.println(password+username);
     return "redirect:/personal";
 }



}