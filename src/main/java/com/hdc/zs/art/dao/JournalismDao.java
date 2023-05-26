package com.hdc.zs.art.dao;

import com.hdc.zs.art.empty.Journalism;

import java.util.List;

public interface JournalismDao {

    public List<Journalism> findNews();
    //管理员管理公告
    public int updateNews(Journalism journalism);
}
