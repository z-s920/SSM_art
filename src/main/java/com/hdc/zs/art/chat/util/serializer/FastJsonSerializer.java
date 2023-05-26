package com.hdc.zs.art.chat.util.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 *
 * Created by DELL(mxd) on 2020/6/10 16:11
 */
public class FastJsonSerializer implements IJsonSerializer {
    /*
    * 使用fastjson序列化
    * */
    public <T> String toJSON(T t){
        if(t==null){
            return null;
        }
        //加上WriteMapNullValue 使得null值也被序列化
        return JSON.toJSONString(t, SerializerFeature.WriteMapNullValue);
    }

    /*
    * 使用fastjson反序列化
    * */
    public <T> T toObject(String json,Class<T> clazz){
        T t = null;
        try {
            t = JSON.parseObject(json,clazz);
        }catch (Exception e){
        	System.out.println("fastJson转换格式出错");
         //   e.printStackTrace();
        }
        return t;
    }
    /*
    * tojsonArray
    * */
    public <T> List<T> toArray(String json,Class<T> clazz){
        try {
            List<T> list = JSON.parseArray(json, clazz);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
