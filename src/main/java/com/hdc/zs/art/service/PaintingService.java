package com.hdc.zs.art.service;

import com.hdc.zs.art.empty.*;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PaintingService {
    public List<art> findpaint();

    public List<Cpaintings> findCpainting();

    public Cpaintings findCpaintingById(int id);

    public void addCpaints(Cpaintings cpa);
    public int updateCpaintsCounts(@Param(value = "count") Integer count,
                                   @Param(value = "paintsName") String paintsName);  // 返回更新条数

    public int updateCpaintsCount(@Param(value = "count") Integer count,@Param(value = "paintsName")String paintsName);

    //导航栏--西方艺术画遍历
    public List<Wpaintings> findWpainting();

    public Wpaintings findWpaintingById(int id);
    public void addWpaints(Wpaintings wpa);

    //购物车修改商品数量
    public int updateWpaintsCount(@Param(value = "count") Integer count,@Param(value = "paintsName")String paintsName);

    //<!--画廊点击商品若相同商品只添加数量-->
    public int updateWpaintsCounts(@Param(value = "count") Integer count,
                                   @Param(value = "paintsName") String paintsName);  // 返回更新条数

    //画廊上传---》插入操作
    public int upLoadPicture(@Param(value = "name") String name,@Param(value = "img") String img,@Param(value = "des") String des );

   //中西方艺术画上传
    public int upLoadChinesePicture(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg") String paintsCoverImg,
                                    @Param(value = "sellingPrice") Integer sellingPrice );

    public int upLoadWesternPicture(@Param(value = "paintsName") String paintsName,@Param(value = "paintsCoverImg") String paintsCoverImg,
                                    @Param(value = "sellingPrice") Integer sellingPrice );

    //对艺术画廊进行分页
    List<art> findPaintsWithPaging(search search);

    int findPaintsWithPagingCount(String search);

    //对中西方艺术画进行分页
    List<Cpaintings> findCPaintsWithPaging(search search);

    int findCPaintsWithPagingCount(String search);

    List<Wpaintings> findWPaintsWithPaging(search search);

    int findWPaintsWithPagingCount(String search);


    //管理员删除某篇中国画
    public int deleteChinese(int id);

    //管理员删除某篇外国画
    public int deleteWestern(int id);

    //管理员删除画廊
    public int deleteGallery(int id);


    //管理员修改画廊
    public int updateGallery(gallery g);

    //管理员修改中国画
    int updateCpicture(backstagepaintings bCp);

    //管理员修改西方画
    int updateWpicture(backstagepaintings bWp);

}
