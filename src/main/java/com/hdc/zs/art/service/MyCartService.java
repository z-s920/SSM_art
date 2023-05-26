package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.Mycart;

import java.util.ArrayList;
import java.util.List;

public interface MyCartService {
    public List<Mycart> findMyCart(String username);
    public ArrayList<String> findMyCartId(String username);
    public int deletePaintsById(int id);
}
