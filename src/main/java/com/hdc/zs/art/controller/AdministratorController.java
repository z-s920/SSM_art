package com.hdc.zs.art.controller;

import com.hdc.zs.art.dao.UserDao;
import com.hdc.zs.art.empty.*;
import com.hdc.zs.art.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdministratorController {


    @Autowired
    private UserService userService;
    @Autowired
    private GuestbookService guestbookService;
    @Autowired
    private JournalismService journalismService;
    @Autowired
    private PaintingService paintingService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MyOrdersService myOrdersService;
    @Autowired
    private CpeopleService cpeopleService;

    @Autowired
    private WpeoplesService wpeoplesService;

    @Secured({"ROLE_管理员"})
    @GetMapping(value = "/administratorLogin")
    public String toadministratorLogin()
    {
        return "/admin/left";
    }

    @GetMapping("/main")
            public String tomain()
    {
        return "admin/main";
    }

    @GetMapping("/UserManage")
    public ModelAndView toUserManage(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                     @RequestParam(value = "limit", required = false,defaultValue = "10") int limit)
    {

        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/UserManage");  // 设置要跳转的页面
        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");

        List<User> userWithPaging = userService.findUserWithPaging(search1);

        modelAndView.addObject("users",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = userService.findUserWithPagingCount(search);
        System.out.println("aasd"+userWithPagingCount);
        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
    }

    //删除某个用户信息

    @GetMapping(value = "/deleteUser")
    public String toDeleteUser(@RequestParam("id") int id)
    {
        userService.deleteUserById(id);
        return "redirect:/UserManage";
    }

    //修改用户信息
    @GetMapping(value = "/updateUser")
    @ResponseBody
    public int toUpdate(   @RequestParam("id") int id,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("power") String power)
    {
        User user = new User(id,username,password,power);
        return userService.updateUser(user);
    }

    //修改画廊
    @GetMapping(value = "/updateGallery")
    @ResponseBody
    public int toUpdate(@RequestParam("id") int id,
                        @RequestParam("name") String name,
                        @RequestParam("des") String des)
    {
        gallery gallery=new gallery(id,name,des);
        return paintingService.updateGallery(gallery);
    }
    //修改新闻信息
   @GetMapping(value = "/updateNews")
   @ResponseBody
   public int toupdateNews(@RequestParam("id") Integer id,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content)

   {
       Journalism journalism= new Journalism(id,title,content);
       return journalismService.updateNews(journalism);
   }

   //更改中国艺术画
   @GetMapping(value = "/updatechinese")
   @ResponseBody
   public int updatechinese(@RequestParam("id") int id,
                       @RequestParam("paintsName") String paintsName,
                       @RequestParam("sellingPrice") Integer sellingPrice)
   {

       backstagepaintings bcp=new backstagepaintings(id,paintsName,sellingPrice);
       System.out.println(bcp);
       return paintingService.updateCpicture(bcp);
   }


    //更改西方艺术画
    @GetMapping(value = "/updatewestern")
    @ResponseBody
    public int updatewestern(@RequestParam("id") int id,
                        @RequestParam("paintsName") String paintsName,
                        @RequestParam("sellingPrice") Integer sellingPrice)
    {

        backstagepaintings bwp=new backstagepaintings(id,paintsName,sellingPrice);
        System.out.println(bwp);
        return paintingService.updateWpicture(bwp);
    }

    //更改画家信息
@GetMapping(value = "/updatecPeoples")
@ResponseBody
public int updatecPeoples(@RequestParam("id") int id,@RequestParam("paintsName") String paintsName,
                            @RequestParam("description") String description)
        {
            updateChinese upc=new updateChinese(id,paintsName,description);
            System.out.println(upc);
        return cpeopleService.updateCpeople(upc);
            }

    //更改西方画家信息
    @GetMapping(value = "/updatewPeoples")
    @ResponseBody
    public int updatewPeoples(@RequestParam("id") int id,@RequestParam("paintsName") String paintsName
                             )
    {
        updateWestern upw=new updateWestern(id,paintsName);
        System.out.println(upw);
        return wpeoplesService.updateWpeople(upw);
    }
    //删除某个用户发表的评论

    @GetMapping(value = "/deleteComment")
    public String toDeleteComment(@RequestParam("id") int id)
    {
       guestbookService.deleteCommentById(id);
        return "redirect:/CommentManage";
    }

    //更新用户信息

  /*  @GetMapping(value = "/updateUser")
    public String toUpdate(@RequestParam("id") int id,User user)
    {
        userService.updateUser(user);
        return "redirect:/UserManage";
    }*/

//评论分页展示

    @GetMapping("/CommentManage")
    public ModelAndView toCommentManage(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                     @RequestParam(value = "limit", required = false,defaultValue = "10") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/CommentManage");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");

        List<guestbook> userWithPaging = guestbookService.findGuestbookWithPaging(search1);

        modelAndView.addObject("guestbooks",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = guestbookService.findGuestbookWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
    }

//展示公告

    @GetMapping(value = "/NewsManage")
            public String toNews(Model model)
    {
        List<Journalism> news = journalismService.findNews();
        System.out.println(news);
        model.addAttribute("news",news);
        return "admin/NewsManage";
    }
    //中西方艺术画分页遍历
    @GetMapping(value = "/ChineseManage")
    public ModelAndView toChinese(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "10") int limit
                                 )
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/chinese");  // 设置要跳转的页面

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
    @GetMapping(value = "/WesternManage")
    public ModelAndView toWestern(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "10") int limit
                                  )
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/western");  // 设置要跳转的页面

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


    //导航栏跳转到画廊管理 ----》分页
    @GetMapping(value = "/GalleryManage")
    public ModelAndView toGalleryManage(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                  @RequestParam(value = "limit", required = false,defaultValue = "10") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/gallery");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<art> userWithPaging = paintingService.findPaintsWithPaging(search1);

        modelAndView.addObject("gallery",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = paintingService.findPaintsWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }


    //导航栏跳转到中国艺术家管理 ----》分页
    @GetMapping(value = "/chinesePeopleManage")
    public ModelAndView tochinesePeopleManage(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                        @RequestParam(value = "limit", required = false,defaultValue = "10") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/ChineseFamous");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Cpeoples> userWithPaging = cpeopleService.findcPeople(search1);

        modelAndView.addObject("cPeoples",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = cpeopleService.findcPeopleWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }
    //导航栏跳转到中国艺术家管理 ----》分页
    @GetMapping(value = "/westernPeopleManage")
    public ModelAndView towesternPeopleManage(String search,@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                              @RequestParam(value = "limit", required = false,defaultValue = "10") int limit)
    {
        search search1=new search(page,limit,search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/WesternFamous");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<Wpeoples> userWithPaging = wpeoplesService.findwPeople(search1);

        modelAndView.addObject("wPeoples",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = wpeoplesService.findwPeopleWithPagingCount(search);

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }


    //删除中国画
    @GetMapping(value = "/deleteChinese")
    public String todeleteChinese(@RequestParam(value = "id") int id)
    {
        paintingService.deleteChinese(id);
        return "redirect:/ChineseManage";
    }
    //删除画廊
    @GetMapping(value = "/deleteGallery")
    public String todeleteGallery(@RequestParam(value = "id")int id)
    {
        paintingService.deleteGallery(id);
        return "redirect:/GalleryManage";
    }
    //删除外国画

    @GetMapping(value = "/deleteWestern")
    public String todeleteWestern(@RequestParam(value = "id") int id)
    {
        paintingService.deleteWestern(id);
        return "redirect:/WesternManage";
    }

    //删除中国艺术家
    @GetMapping(value = "/deletecPeoples")
    public String todeletecPeoples(@RequestParam(value = "id") int id)
    {
        cpeopleService.deleteChinesePeople(id);
        return "redirect:/chinesePeopleManage";
    }

    //删除西方艺术家
    @GetMapping(value = "/deletewPeoples")
    public String todeletewPeoples(@RequestParam(value = "id") int id)
    {
        wpeoplesService.deleteWesternPeople(id);
        return "redirect:/westernPeopleManage";
    }

/*    @GetMapping(value = "/deletewPeoples")
    public String todeletewPeoples(@RequestParam(value = "id") int id)
    {
        wpeoplesServic(id);
        return "redirect:/chinesePeopleManage";
    }*/

    //禁用用户在发评论
    @GetMapping("forbidComment")
    public String toforbidComment(@RequestParam(value = "username") String username)
    {
//        System.out.println(username);
        int i = userService.updateUserPowerByUserName(username, "游客");
        System.out.println(i);
        return "redirect:/CommentManage";
    }

        //添加用户
    @PostMapping(value = "/admin/register")
    @ResponseBody
    public int Register(String username, String password, String power, Model model) {
        System.out.println(username+"--"+password+"---"+power);
        int comport = userService.comport(username);
        System.out.println(comport);
        if (comport == 0) {
            userService.addUser(username, password, power);
            model.addAttribute("msg", "恭喜您注册成功！");
            return 1;
        }
        model.addAttribute("msg", "用户名已存在，请重新输入！");
        return 0;
    }

//查看交易订单记录
    @GetMapping(value = "/OrdersManage")
    public ModelAndView toOrdersManage(@RequestParam(value = "page", required = false,defaultValue = "1") int page,
                                        @RequestParam(value = "limit", required = false,defaultValue = "10") int limit
                                       )
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/OrderManage");  // 设置要跳转的页面

        System.out.println("查询弟："+page+ "页，每页：" + limit + "条数据");
        List<MyOrders> userWithPaging =myOrdersService.findOrdersWithPaging(page, limit);

        System.out.println(userWithPaging);
        modelAndView.addObject("orders",userWithPaging);
        modelAndView.addObject("limit",limit);

        int userWithPagingCount = myOrdersService.findOrdersWithPagingCount();

        modelAndView.addObject("total",userWithPagingCount);
        modelAndView.addObject("page",Math.ceil((userWithPagingCount*1.0/limit)));

        return modelAndView;
      /*  List<Cpaintings> cpaintings=paintingService.findCpainting();
        model.addAttribute("cpaintings",cpaintings);
        return "ChinesePainting";*/
    }
    @GetMapping(value = "/manageUpdatePass")
    public String toUpdatePass(String password,String username)
    {
        System.out.println(password);
        userService.updatePass(username,password);
        System.out.println(password+username);
        return "admin/left";
    }

}