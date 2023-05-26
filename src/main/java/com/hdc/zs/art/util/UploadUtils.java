package com.hdc.zs.art.util;

import java.io.File;

/**
 * 配合MvcConfigs类完成上传文件无法显示问题
 * Created by DELL(mxd) on 2020/6/13 20:12
 */
public class UploadUtils {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static/asserts/image";

    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        System.out.println("目标文件是否存在："+fileDir.exists());
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
