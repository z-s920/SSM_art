package com.hdc.zs.art.serviceimpl;


import com.hdc.zs.art.dao.PaintingDao;
import com.hdc.zs.art.empty.PayLog;
import com.hdc.zs.art.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("paylogservice")
public class PayLogServiceImpl implements PayLogService {
    @Autowired
    private PaintingDao payLogDao;
    @Override
    public int addSn(PayLog payLog) {
        System.out.println(payLog);
       int i =this.payLogDao.addSn(payLog);
       return i;
    }

    @Override
    public int deleteAlipayPaints(String name) {
        int j =this.payLogDao.deleteAlipayPaints(name);
        return j;
    }
}
