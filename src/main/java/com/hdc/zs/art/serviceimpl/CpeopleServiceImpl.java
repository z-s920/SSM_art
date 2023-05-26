package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.FamousPeople;
import com.hdc.zs.art.empty.Cpeoples;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.empty.updateChinese;
import com.hdc.zs.art.service.CpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CpeopleService")
public class CpeopleServiceImpl implements CpeopleService {
@Autowired
private FamousPeople famousPeople;


    @Override
    public List<Cpeoples> findcPeople(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.famousPeople.findcPeople(search);
    }

    @Override
    public int findcPeopleWithPagingCount(String search) {
        int i =this.famousPeople.findcPeopleWithPagingCount(search);
        return i;
    }


    @Override
    public int deleteChinesePeople(int id) {
        int i =this.famousPeople.deleteChinesePeople(id);
        return i;
    }

    @Override
    public int updateCpeople(updateChinese upc) {
        int i=this.famousPeople.updateCpeople(upc);
        return i;
    }

    @Override
    public int upLoadChinesePeople(String paintsName, String paintsCoverImg) {
        int i=this.famousPeople.upLoadChinesePeople(paintsName,paintsCoverImg);
        return i;
    }

    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){
        return (page-1)*limit;
    }
}
