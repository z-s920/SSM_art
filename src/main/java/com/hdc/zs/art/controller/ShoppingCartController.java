
package com.hdc.zs.art.controller;


import com.hdc.zs.art.VO.NewBeeMallShoppingCartItemVO;
import com.hdc.zs.art.empty.Mycart;
import com.hdc.zs.art.empty.PayLog;
import com.hdc.zs.art.service.MyCartService;
import com.hdc.zs.art.service.PayLogService;
import com.hdc.zs.art.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ShoppingCartController {

    @Autowired
    private MyCartService myCartService;
    @Autowired
    private PayLogService payLogService;

    /**
     * 去购物车界面
     */
    @GetMapping(value = "/Mycart")
    public String tocart(HttpServletRequest request, Integer id,String img,String name,Integer price,Integer count,Integer paintsId,
                         HttpSession session){

        String username = (String) session.getAttribute("username");

        System.out.println("当前登录用户的username:" + username);

        // 计算总个数
        int itemsTotal = 0;
        // 计算总价钱
        int priceTotal = 0;    //  总价   把数据库的单价  遍历并计算
        // 去数据库查询购物车商品
        List<Mycart> myShoppingCartItems = myCartService.findMyCart(username);
        for (Mycart list:
                myShoppingCartItems) {
            int i = list.getCount() * list.getPrice();
            priceTotal += i;

        }
        itemsTotal = myShoppingCartItems.size();

        // 现在模拟假数据

        request.setAttribute("itemsTotal", itemsTotal);
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "user/shoppingcar";
    }


//    @PostMapping("/shop-cart")
//    @ResponseBody
//    public Object saveNewBeeMallShoppingCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem,
//                                                 HttpSession httpSession) {
//        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
//        newBeeMallShoppingCartItem.setUserId(user.getUserId());
//        //todo 判断数量
//        String saveResult = newBeeMallShoppingCartService.saveNewBeeMallCartItem(newBeeMallShoppingCartItem);
//        //添加成功
//        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
//            return ResultGenerator.genSuccessResult();
//        }
//        //添加失败
//        return ResultGenerator.genFailResult(saveResult);
//    }

//    @PutMapping("/shop-cart")
//    @ResponseBody
//    public Result updateNewBeeMallShoppingCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem,
//                                                   HttpSession httpSession) {
//        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
//        newBeeMallShoppingCartItem.setUserId(user.getUserId());
//        //todo 判断数量
//        String updateResult = newBeeMallShoppingCartService.updateNewBeeMallCartItem(newBeeMallShoppingCartItem);
//        //修改成功
//        if (ServiceResultEnum.SUCCESS.getResult().equals(updateResult)) {
//            return ResultGenerator.genSuccessResult();
//        }
//        //修改失败
//        return ResultGenerator.genFailResult(updateResult);
//    }
@GetMapping("deletePaintsById")
public String toDelete(@RequestParam(value = "id") int id,String username, Model model)
{
    ArrayList<String> myCartIdt=myCartService.findMyCartId(username);
    if (myCartIdt==null)
    {
        System.out.println("删除失败");
        /*model.addAttribute("msg","删除失败");*/
    }
    System.out.println(myCartIdt);
    myCartService.deletePaintsById(id);
    return "redirect:/Mycart";
}
/**
     * 跳转支付详情界面
     */
    @GetMapping("/shop-cart")
    public String settlePage(HttpServletRequest request, Integer id, String img,String name, Integer price, Integer count, Integer paintsId,
                             HttpSession httpSession) throws ParseException {
        String username =(String) httpSession.getAttribute("username");
        int priceTotal = 0;
//        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute("");
        List<Mycart> myShoppingCartItems = myCartService.findMyCart(username);
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //无数据则不跳转至结算页
            return "user/shoppingcar";
        } else {
            //总价
            for (Mycart mycart : myShoppingCartItems) {
                priceTotal += mycart.getCount() * mycart.getPrice();
            }
            if (priceTotal < 1) {
                return "error/error_5xx";
            }
        }
        // 获取随机sn


        Date dd=new Date();
        //格式化
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String times=sim.format(dd);
        Date date = sim.parse(times);
        PayLog payLog=new PayLog();
        String sn = StringUtil.generateSn("艺术画展", "");

        payLog.setSn(sn);
        payLog.setTotal_amount(priceTotal);//付款金额
        String PictureName = "";
        int j=1;
        for (Mycart mycart : myShoppingCartItems) {
            if (j<myShoppingCartItems.size()) {
                PictureName += mycart.getName() + "、";
            }
            else {
                PictureName += mycart.getName() ;
            }
            j++;
        }

        payLog.setTitle(PictureName);//画名+"等艺术画作品"
        payLog.setInfo("艺术作品");



        payLog.setCreate_time(date);
        payLog.setUpdate_time(date);
        payLog.setPayment(1);
        payLog.setPay_time(date);
        payLog.setPay_sn(null);
        payLog.setRefund_amount(null);
        payLog.setRefund_info(null);
        payLog.setRefund_sn(null);
        payLog.setRefund_time(null);
        payLog.setStatus(0);

        // 进行插入
        int i = payLogService.addSn(payLog);
        System.out.println(i);
        // 将sn 存request域
        request.setAttribute("sn",sn);
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "user/order-settle";
    }






}
