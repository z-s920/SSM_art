package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.art;
import com.hdc.zs.art.empty.guestbook;
import com.hdc.zs.art.empty.search;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestbookService {
    public void addGuestbook(String comment, String stars,String username,String name);
    public List<guestbook> findGuest(String paintsName);
    public art findPictureById(int id);
    public int deletePaintsById(int id);


    public art findPictureBypaintsName(String paintsName);

    //管理员界面用户分页
    List<guestbook> findGuestbookWithPaging(search search);

    int findGuestbookWithPagingCount(String search);

    //管理员删除某个用户发表的评论
    public int deleteCommentById(int id);

}
