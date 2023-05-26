package com.hdc.zs.art.controller;

import com.hdc.zs.art.dao.PaintingDao;
import com.hdc.zs.art.empty.Cpaintings;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.empty.Wpaintings;
import com.hdc.zs.art.empty.art;
import com.hdc.zs.art.service.MyCartService;
import com.hdc.zs.art.service.PaintingService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PaintingController {



    @Autowired
    private PaintingService paintingService;


    @Autowired
    private MyCartService myCartService;



//跳转到艺术画廊
    @GetMapping(value = "/exhibits")
    public ModelAndView exhibits(String search,@RequestParam(value = "page",required = false,defaultValue = "1") int page, @RequestParam(value = "limit",required = false,defaultValue = "6") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exhibits");

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");

        List<art> artWithPaging = paintingService.findPaintsWithPaging(search1);

        modelAndView.addObject("arts",artWithPaging);
        modelAndView.addObject("limit",limit);

        int paintsWithPagingCount = paintingService.findPaintsWithPagingCount(search);

        modelAndView.addObject("total",paintsWithPagingCount);
        modelAndView.addObject("page",Math.ceil((paintsWithPagingCount*1.0/limit)));


        return modelAndView;
    }


    //点击购物车数量，数量进行加减
    @GetMapping(value = "/paintsCount")
    public String topaintsCount(@RequestParam("paintsCount") Integer paintsCount,
                                        @RequestParam("paintsName") String paintsName)
    {
     /*   System.out.println("加数量");*/
        paintingService.updateCpaintsCount(paintsCount, paintsName);
        paintingService.updateWpaintsCount(paintsCount, paintsName);
        System.out.println(paintsName);
        return "redirect:/Mycart";
    }


    //导航栏跳转到中国画 ----》分页
    @GetMapping(value = "/chinese")
    public ModelAndView toChinese(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "12") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ChinesePainting");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Cpaintings> userWithPaging = paintingService.findCPaintsWithPaging(search1);

        modelAndView.addObject("cpaintings",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = paintingService.findCPaintsWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }

    //导航栏跳转到中国画 ----》分页
    @GetMapping(value = "/western")
    public ModelAndView toWestern(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "12") int limit,
                                  Integer id,String paintsName,Integer sellingPrice,String paintsCoverImg,Model model)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("WesternPainting");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Wpaintings> userWithPaging = paintingService.findWPaintsWithPaging(search1);

        modelAndView.addObject("wpaintings",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = paintingService.findWPaintsWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }



   /* //导航栏跳转到西方画
    @GetMapping(value = "/western")
    public String toWhinese(Integer id,String paintsName,Integer sellingPrice,String paintsCoverImg,Model model)
    {
        List<Wpaintings> wpaintings=paintingService.findWpainting();
        model.addAttribute("wpaintings",wpaintings);
        return "WesternPainting";
    }*/

    //获取艺术画ID，若所点击的画作购物车已有，则只加数量
    @GetMapping(value = "/myadd")
    public String shopping(@RequestParam("cpaintingsId") String p_name,
                           @RequestParam("p_id") Integer p_id,
                           Model model, HttpSession session)
    {
        String username = (String) session.getAttribute("username");
        Cpaintings cpa=paintingService.findCpaintingById(p_id);
        cpa.setUsername(username);
        System.out.println("controller------>"+username);
        ArrayList<String> myCartId = myCartService.findMyCartId(username);
        String[] strings = myCartId.toArray(new String[myCartId.size()]);
        System.out.println("是否包含：" + useList(strings,p_name));

        if (useList(strings,p_name))
        {
            int i = paintingService.updateCpaintsCounts(1, p_name);
            System.out.println(1+p_name);
        }
        else
        {
            paintingService.addCpaints(cpa);
        }
//        myCartId.forEach((data)->{
//            if (data.equals(p_name)&& myCartId.get(myCartId.size() - 1).equals(p_name))
//                System.out.println("图片已存在");
//                    /*paintingService.updateCpaintsCounts(count,name))*/
//            else
//                System.out.println("进行添加操作");
//        });
        List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        model.addAttribute("cpa",cpa);
        return "ChinesePainting";
    }


    //
    @GetMapping(value = "/myAdd")
    public String toshopping(@RequestParam("wpaintingsId") String p_name,
                           @RequestParam("wp_id") Integer wp_id,
                           Model model, HttpSession session)
    {
        String username = (String) session.getAttribute("username");
        Wpaintings wpa=paintingService.findWpaintingById(wp_id);
        wpa.setUsername(username);
        System.out.println("controller------>"+username);
        ArrayList<String> myCartId = myCartService.findMyCartId(username);
        String[] strings = myCartId.toArray(new String[myCartId.size()]);
     /*   System.out.println("是否包含：" + useList(strings,p_name));*/

        if (useList(strings,p_name))
        {
            int i = paintingService.updateWpaintsCounts(1, p_name);
            System.out.println(1+p_name);
        }
        else
        {
            paintingService.addWpaints(wpa);
        }
//        myCartId.forEach((data)->{
//            if (data.equals(p_name)&& myCartId.get(myCartId.size() - 1).equals(p_name))
//                System.out.println("图片已存在");
//                    /*paintingService.updateCpaintsCounts(count,name))*/
//            else
//                System.out.println("进行添加操作");
//        });
        List<Wpaintings> wpaintings=paintingService.findWpainting();
        model.addAttribute("wpaintings",wpaintings);
        model.addAttribute("wpa",wpa);
        return "WesternPainting";


        //跳转到文件上传页面

    }


    private static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    @GetMapping(value = "uploadfiles")
    public String toload()
    {
        return "Uplpadfiles";
    }



    @GetMapping(value = "/uploadChinese")
    public String touploadChinese()
    {
        return "admin/uploadChinese";
    }

    @GetMapping(value ="/uploadWestern" )
    public String touploadWestern()
    {
        return "admin/uploadWestern";
    }

@GetMapping(value = "/uploadWesternPeople")
public String touploadWesternPeople()
{
    return "admin/updateWesternPeople";
}


    @GetMapping(value = "/uploadChinesePeople")
    public String touploadChinesePeople()
    {
        return "admin/updateChinesePeople";
    }
    @GetMapping("/zhuye")
    public String zhuye()
    {
        return "home";
    }
}
