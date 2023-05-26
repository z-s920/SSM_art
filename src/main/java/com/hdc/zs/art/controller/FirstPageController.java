package com.hdc.zs.art.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstPageController {

    @GetMapping("/education")
     public String toeducation()
     {
         return "/education";
     }
     @GetMapping("/onlineJournal")
     public String toonline()
     {
         return "/onlineJournal";
     }
     @GetMapping("/tripBroad")
    public String totrip() {
         return "/tripBroad";

     }
     @GetMapping("/onlineMagazine")
     public String toonlineMagazine() {
         return "/onlineMagazine";

     }
    @GetMapping("/Roamingisland")
    public String toRoamingisland() {
        return "/Roamingisland";

    }
    @GetMapping("/onlineBook")
    public String toonlineBook() {
        return "/onlineBook";

    }
    }
