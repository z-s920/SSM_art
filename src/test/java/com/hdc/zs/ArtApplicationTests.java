
package com.hdc.zs;

import com.hdc.zs.art.ArtApplication;
import com.hdc.zs.art.empty.User;
import com.hdc.zs.art.service.UserService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ArtApplication.class)
 class ArtApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//            List<User> userWithPaging = userService.findUserWithPaging(1, 10);
//
//            userWithPaging.forEach(System.out::println);


        User user =new User();
        user.setId(32);
        user.setUsername("zs");
        user.setPassword("999");
        user.setPower("学生");
        userService.updateUser(user);

    }

}

