package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.FamousPeople;
import com.hdc.zs.art.empty.Wpeoples;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.empty.updateWestern;
import com.hdc.zs.art.service.WpeoplesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("wpeoplekService")
public class WpeoplesServiceImpl implements WpeoplesService {
    @Autowired
    private FamousPeople famousPeople;


    @Override
    public List<Wpeoples> findwPeople(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.famousPeople.findwPeople(search);
    }

    @Override
    public int findwPeopleWithPagingCount(String search) {
        int i =this.famousPeople.findwPeopleWithPagingCount(search);
        return i;
    }

    @Override
    public int deleteWesternPeople(int id) {
        int i =this.famousPeople.deleteWesternPeople(id);
        return i;
    }

    @Override
    public int updateWpeople(updateWestern upw) {
        int i=this.famousPeople.updateWpeople(upw);
        return i;
    }

    @Override
    public int upLoadWesternPeople(String paintsName, String paintsCoverImg) {
        int i=this.famousPeople.upLoadWesternPeople(paintsName,paintsCoverImg);
        return i;
    }


    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){
        return (page-1)*limit;
    }
}
