/*
package com.hdc.zs.art.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.hdc.zs.art.service.SendSms;

import java.util.HashMap;
import java.util.Map;

public class SendSmsImpl implements SendSms {
    @Override
    public boolean send(String phoneNum, String templateCode, Map<String, Object> code) {
        //链接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G9jW2AoRErRjeXnU1JN", "R2x7hlmIVkvwvpzs0PqP8A8Rbv91dS");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("AddSmsSign");
        //自定义的参数(手机号、验证码、签名、模板)
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "校内艺术画展系统");
        request.putQueryParameter("SignName", templateCode);
        //构建一个短信的验证码
      */
/*  HashMap<String,Object> map=new HashMap<>();
        map.put("code",2222);*//*

        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();//看看是否发送成功
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}
*/
