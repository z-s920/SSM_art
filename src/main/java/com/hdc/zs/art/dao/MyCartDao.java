package com.hdc.zs.art.dao;


import com.hdc.zs.art.empty.Mycart;

import java.util.ArrayList;
import java.util.List;

public interface MyCartDao {
    public List<Mycart> findMyCart(String username);
    public ArrayList<String> findMyCartId(String username);

    //实现删除购物车商品操作

    public int deletePaintsById(int id);
}
