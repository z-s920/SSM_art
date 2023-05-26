package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.GuestbookDao;
import com.hdc.zs.art.empty.art;
import com.hdc.zs.art.empty.guestbook;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("guestbookservice")
public class GuestbookServiceImpl implements GuestbookService {

    @Autowired
    private GuestbookDao guestbookDao;

    //添加评论
    @Override
    public void addGuestbook(String comment, String stars,String username,String name) {
        Date dd=new Date();
        //格式化
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String times=sim.format(dd);
        this.guestbookDao.addGuestbook(comment,stars,times,username,name);
    }
 //遍历评论
    @Override
    public List<guestbook> findGuest(String paintsName) {
        List<guestbook> guest=this.guestbookDao.findGuest(paintsName);
        return guest;
    }

    @Override
    public art findPictureById(int id) {
        art a=this.guestbookDao.findPictureById(id);
        return a;
    }

    @Override
    public int deletePaintsById(int id) {
        int i=this.guestbookDao.deletePaintsById(id);
        return i;
    }

    @Override
    public art findPictureBypaintsName(String paintsName) {
        return guestbookDao.findPictureBypaintsName(paintsName);
    }
    @Override
    public List<guestbook> findGuestbookWithPaging(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.guestbookDao.findGuestbookWithPaging(search);
    }

    @Override
    public int findGuestbookWithPagingCount(String search) {
        int total=guestbookDao.findGuestbookWithPagingCount(search);
        return total;
    }

    //管理员删除某个用户发表的评论
    @Override
    public int deleteCommentById(int id) {
        int i= this.guestbookDao.deleteCommentById(id);
       return i;
    }

    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){

        // page:              1, 2,    3,   4,   5,6,7,8,9...... 第几页，  limit : 10
        // 而数据库想要的page   0, 10 , 20 , 30
        // 怎么转换

        return (page-1)*limit;
    }
}
