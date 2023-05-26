package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.MyOrders;
import com.hdc.zs.art.service.MyOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyOrdersController {
    @Autowired
    private MyOrdersService myOrdersService;
    @GetMapping("/orders")
    public String toOrders(String name, Model model, HttpSession session)
    {
        String username=(String) session.getAttribute("username");
        List<MyOrders> myOrders=this.myOrdersService.findAlipayPaints(username);
        model.addAttribute("myOrders",myOrders);
        System.out.println(myOrders);
        return "my-order";
    }
    @GetMapping("/return")
    public String toReturn()
    {
        return "redirect:/shop-cart";
    }
}
