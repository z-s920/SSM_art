package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.Cpeoples;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.empty.updateChinese;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpeopleService {


    public List<Cpeoples> findcPeople(search search);

    int findcPeopleWithPagingCount(String search);

    //管理员删除某个中国艺术家
    public int deleteChinesePeople(int id);

    //修改中画家
    public int updateCpeople(updateChinese upc
    );


    //画家上传---》插入操作
    public int upLoadChinesePeople(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg") String paintsCoverImg);
}
