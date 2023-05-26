package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.Journalism;
import com.hdc.zs.art.service.JournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@Controller
public class JournalismController {
    @Autowired
    private JournalismService journalismService;
    @GetMapping(value = "/news")
    public String News(Model model)
    {
        List<Journalism> journalisms=journalismService.findNews();
        model.addAttribute("journalisms",journalisms);
        return "home";
    }
}
