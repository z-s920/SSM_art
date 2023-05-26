package com.hdc.zs.art.dao;

import com.hdc.zs.art.empty.art;
import com.hdc.zs.art.empty.guestbook;
import com.hdc.zs.art.empty.search;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuestbookDao {
    public void addGuestbook(@Param("comment") String comment, @Param("stars") String stars,@Param("times") String times,
                             @Param("username")String username,@Param("paintsName") String name);
    /* public void addGuestbook()*/
    public List<guestbook> findGuest(String paintsName);
    public art findPictureById(int id);

    public art findPictureBypaintsName(String paintsName);


    public int deletePaintsById(int id);

    //管理员界面用户分页
    List<guestbook> findGuestbookWithPaging(search search);
    int findGuestbookWithPagingCount(String search);

    //管理员删除某个用户发表的评论
    public int deleteCommentById(int id);
}
