/*
package com.hdc.zs.art.controller;

import com.hdc.zs.art.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class SmsApiController {
    @Autowired
    private SendSms sendSms;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("/send/{phone}")
    public String code(@PathVariable("phone") String phone){
        //调用发送方法（模拟真实业务 利用radis）
        String code =redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code))
        {
            return phone + ":" + code + "已存在，还没有过期";
        }
        code = UUID.randomUUID().toString().substring(0,4);
        HashMap<String,Object> param = new HashMap<>();
        param.put("code",code);

        boolean isSend= sendSms.send(phone,"SMS_211275777",param);
        if (isSend)
        {
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.SECONDS);
            return  phone + ":" + code + "发送成功！";
        }
        else {
            return "发送失败！";
        }
    }
}
*/
