package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.Mycart;
import com.hdc.zs.art.service.MyCartService;
import com.hdc.zs.art.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PaySuccessController {
    @Autowired
    private MyCartService myCartService;
    @Autowired
    private PayLogService payLogService;
    @GetMapping("/PayReturn")
    public String toShopcar(HttpServletRequest request, HttpSession session,String name)
    {
        String uname=(String) session.getAttribute("username");
        //进行删除操作
        System.out.println(uname);
        payLogService.deleteAlipayPaints(uname);
        System.out.println(uname);
        // 计算总个数
        int itemsTotal = 0;
        // 计算总价钱
        int priceTotal = 0;    //  总价   把数据库的单价  遍历并计算
        // 去数据库查询购物车商品
        List<Mycart> myShoppingCartItems = myCartService.findMyCart(name);
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
}
