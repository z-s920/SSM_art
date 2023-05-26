package com.hdc.zs.art.dao;

import com.hdc.zs.art.empty.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamousPeople {


    public List<Cpeoples> findcPeople(search search);

    int findcPeopleWithPagingCount(String search);

    //管理员删除某个中国艺术家
    public int deleteChinesePeople(int id);

    //管理员删除某个中国艺术家
    public int deleteWesternPeople(int id);

    //修改中画家
    public int updateCpeople(updateChinese upc
    );

    //修改中画家
    public int updateWpeople(updateWestern upw
    );

    //画家上传---》插入操作
    public int upLoadChinesePeople(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg") String paintsCoverImg );

    //画家上传---》插入操作
    public int upLoadWesternPeople(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg")String paintsCoverImg);
    public List<Wpeoples> findwPeople(search search);

    int findwPeopleWithPagingCount(String search);

}
