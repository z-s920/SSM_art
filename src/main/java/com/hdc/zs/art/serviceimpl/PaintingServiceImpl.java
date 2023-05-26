package com.hdc.zs.art.serviceimpl;

import com.hdc.zs.art.dao.PaintingDao;
import com.hdc.zs.art.empty.*;
import com.hdc.zs.art.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("paintingservice")
public class PaintingServiceImpl implements PaintingService {
    @Autowired
    private PaintingDao paintingDao;

    @Override
    public List<art> findpaint() {
        List<art> paint=this.paintingDao.findpaint();
        return paint;
    }

    @Override
    public List<Cpaintings> findCpainting() {
        return this.paintingDao.findCpainting();
    }

    @Override
    public Cpaintings findCpaintingById(int id) {
        Cpaintings cpa=this.paintingDao.findCpaintingById(id);
        return cpa;
    }

    @Override
    public void addCpaints(Cpaintings cpa) {
    this.paintingDao.addCpaints(cpa);
    }

    @Override
    public int updateCpaintsCounts(Integer count,String name) {
        int i=this.paintingDao.updateCpaintsCounts(count, name);
        return i;
    }
    @Override
    public int updateCpaintsCount(Integer count, String paintsName) {
        int i=this.paintingDao.updateCpaintsCount(count, paintsName);
        return i;
    }

    @Override
    public List<Wpaintings> findWpainting() {
        return this.paintingDao.findWpainting();
    }
  /*  public Cpaintings findCpaintingById(int id) {
        Cpaintings cpa=this.paintingDao.findCpaintingById(id);
        return cpa;
    }*/

    @Override
    public Wpaintings findWpaintingById(int id) {
        Wpaintings wpa=this.paintingDao.findWpaintingById(id);
        return wpa;
    }

    @Override
    public void addWpaints(Wpaintings wpa) {
        this.paintingDao.addWpaints(wpa);
    }

    @Override
    public int updateWpaintsCount(Integer count, String paintsName) {
        int i=this.paintingDao.updateWpaintsCount(count, paintsName);
        return i;
    }

    @Override
    public int updateWpaintsCounts(Integer count, String name) {
        int i=this.paintingDao.updateWpaintsCounts(count, name);
        return i;
    }

    @Override
    public int upLoadPicture(String name, String img, String des) {
        int i=this.paintingDao.upLoadPicture(name,img,des);
        return i;
    }

    @Override
    public int upLoadChinesePicture(String paintsName, String paintsCoverImg, Integer sellingPrice) {
        int i=this.paintingDao.upLoadChinesePicture(paintsName,paintsCoverImg,sellingPrice);
        return i;
    }

    @Override
    public int upLoadWesternPicture(String paintsName, String paintsCoverImg, Integer sellingPrice) {
        int i=this.paintingDao.upLoadWesternPicture(paintsName,paintsCoverImg,sellingPrice);
        return i;
    }


    //前台画廊分页
    @Override
    public List<art> findPaintsWithPaging(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
       return this.paintingDao.findPaintsWithPaging(search);
    }

    @Override
    public int findPaintsWithPagingCount(String search) {
        int i =this.paintingDao.findPaintsWithPagingCount(search);
        return i;
    }

    //国画分页
    @Override
    public List<Cpaintings> findCPaintsWithPaging(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.paintingDao.findCPaintsWithPaging(search);
    }

    @Override
    public int findCPaintsWithPagingCount(String search) {
        int i =this.paintingDao.findCPaintsWithPagingCount(search);
        return i;
    }
    //外画分页
    @Override
    public List<Wpaintings> findWPaintsWithPaging(search search) {
        int i=VoTODatabase(search.getPage(),search.getLimit());
        search.setPage(i);
        return this.paintingDao.findWPaintsWithPaging(search);

    }

    @Override
    public int findWPaintsWithPagingCount(String search) {
        int i =this.paintingDao.findWPaintsWithPagingCount(search);
        return i;
    }



    @Override
    public int deleteChinese(int id) {
        int i=this.paintingDao.deleteChinese(id);
        return i;
    }

    @Override
    public int deleteWestern(int id) {
        int i=this.paintingDao.deleteWestern(id);
        return i;
    }

    @Override
    public int deleteGallery(int id) {
        int i=this.paintingDao.deleteWestern(id);
        return i;


    }

    @Override
    public int updateGallery(gallery g) {
        int i =this.paintingDao.updateGallery(g);
        return i;
    }

    @Override
    public int updateCpicture(backstagepaintings bCp) {
        int i=this.paintingDao.updateCpicture(bCp);
        return i;
    }

    @Override
    public int updateWpicture(backstagepaintings bWp) {
        int i=this.paintingDao.updateWpicture(bWp);
        return i;
    }


    // 算法：将用户传入数据跟数据库想要的数据一一对应起来
    private int VoTODatabase(int page,int limit){
        return (page-1)*limit;
    }
}
