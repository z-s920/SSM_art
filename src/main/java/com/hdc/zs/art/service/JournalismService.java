package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.Journalism;
import com.hdc.zs.art.empty.guestbook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JournalismService {

    public List<Journalism> findNews();

    //管理员管理公告
    public int updateNews(Journalism journalism);

}
