package com.hdc.zs.art.serviceimpl;


import com.hdc.zs.art.dao.MyOrdersDao;
import com.hdc.zs.art.empty.MyOrders;
import com.hdc.zs.art.service.MyOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("MyOrdersService")
public class MyOrdersServiceImpl implements MyOrdersService {
    @Autowired
    private MyOrdersDao myOrdersDao;
    @Override
    public List<MyOrders> findAlipayPaints(String name) {
        List<MyOrders> myOrders=this.myOrdersDao.findAlipayPaints(name);
        return myOrders;
    }

    @Override
    public List<MyOrders> findOrdersWithPaging(int page, int limit) {
        int i=VoTODatabase(page,limit);
        return this.myOrdersDao.findOrdersWithPaging(i,limit);
    }

    @Override
    public int findOrdersWithPagingCount() {
        int i=this.myOrdersDao.findOrdersWithPagingCount();
        return i;
    }
    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){
        return (page-1)*limit;
    }
}
