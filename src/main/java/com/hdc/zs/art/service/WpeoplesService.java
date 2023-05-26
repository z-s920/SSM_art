package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.Wpeoples;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.empty.updateWestern;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WpeoplesService {
    public List<Wpeoples> findwPeople(search search);

    int findwPeopleWithPagingCount(String search);

    //管理员删除某个中国艺术家
    public int deleteWesternPeople(int id);

    //修改中画家
    public int updateWpeople(updateWestern upw);

    //画家上传---》插入操作
    public int upLoadWesternPeople(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg")String paintsCoverImg);

}
