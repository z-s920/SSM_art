package com.hdc.zs.art.chat.util;


import com.hdc.zs.art.chat.util.serializer.FastJsonSerializer;
import com.hdc.zs.art.chat.util.serializer.IJsonSerializer;

/**
 *
 * Created by DELL(mxd) on 2020/6/10 16:11
 */
public class LayIMFactory {
    //创建序列化器
    public static IJsonSerializer createSerializer(){
        return new FastJsonSerializer();
    }




}
