package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.MyCartDao;
import com.hdc.zs.art.empty.Mycart;
import com.hdc.zs.art.service.MyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("mycartservice")
public class MyCartServiceImpl implements MyCartService {

    @Autowired
    private MyCartDao myCartDao;
    @Override
    public List<Mycart> findMyCart(String username) {
        List<Mycart> mycarts=this.myCartDao.findMyCart(username);
        return mycarts;
    }

    @Override
    public ArrayList<String> findMyCartId(String username) {
        ArrayList<String> objects = this.myCartDao.findMyCartId(username);
        return objects;
    }

    @Override
    public int deletePaintsById(int id) {
        int mycart=this.myCartDao.deletePaintsById(id);
        return mycart;
    }


}
