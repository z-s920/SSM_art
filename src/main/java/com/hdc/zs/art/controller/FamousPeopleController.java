package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.Cpeoples;
import com.hdc.zs.art.empty.Wpeoples;
import com.hdc.zs.art.empty.search;
import com.hdc.zs.art.service.CpeopleService;
import com.hdc.zs.art.service.WpeoplesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FamousPeopleController {

    @Autowired
    private CpeopleService cpeopleService;



    @Autowired
    private WpeoplesService wpeoplesService;

    //导航栏跳转到中国画 ----》分页
    @GetMapping(value = "/chinesepeople")
    public ModelAndView toChinese(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "12") int limit
                                 )
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ChinesePeople");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Cpeoples> userWithPaging = cpeopleService.findcPeople(search1);
        System.out.println(userWithPaging);

        modelAndView.addObject("cpeoples",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = cpeopleService.findcPeopleWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }

    //导航栏跳转到中国画 ----》分页
    @GetMapping(value = "/westernpeople")
    public ModelAndView toWestern(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "12") int limit
    )
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("WesternPeople");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Wpeoples> userWithPaging = wpeoplesService.findwPeople(search1);
        System.out.println(userWithPaging);

        modelAndView.addObject("wpeoples",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = wpeoplesService.findwPeopleWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }
}
