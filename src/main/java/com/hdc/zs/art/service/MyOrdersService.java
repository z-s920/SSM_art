package com.hdc.zs.art.service;

import com.hdc.zs.art.dao.MyOrdersDao;
import com.hdc.zs.art.empty.MyOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyOrdersService {

    //查询订单
    public List<MyOrders> findAlipayPaints(String name);

    //后台分页查询订单
    List<MyOrders> findOrdersWithPaging(@Param("page") int page, @Param("limit") int limit);

    int findOrdersWithPagingCount();}
