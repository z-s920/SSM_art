package com.hdc.zs.art.controller;

import com.hdc.zs.art.empty.art;
import com.hdc.zs.art.empty.guestbook;
import com.hdc.zs.art.service.GuestbookService;
import com.hdc.zs.art.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class GuestbookController {
    @Autowired
    private GuestbookService guestbookService;
    @Autowired
    private PaintingService paintingService;
  /*  @GetMapping(value = "comment")
    public String tocomment(){
        return "message";
    }*/
    @GetMapping(value = "/comment")
    public String message(@RequestParam("id") Integer id, String name, String img, String desc , String comment, String stars, Model model)
    {

        art painting=guestbookService.findPictureById(id);
        System.out.println(painting);
        model.addAttribute("painting",painting);
        List<guestbook> guest=guestbookService.findGuest(painting.getName());
        System.out.println(guest);
        model.addAttribute("guestbook",guest);
            return "index";
    }

    @Secured({"ROLE_学生","ROLE_管理员","ROLE_教师","ROLE_收藏爱好者","ROLE_校外艺术家"})
    @GetMapping(value = "/message")
            public String tomessage(Model model,HttpSession session, @RequestParam("comment") String comment, @RequestParam("stars") String stars,@RequestParam("name") String name)
    {

        String username=(String) session.getAttribute("username");
        System.out.println(comment+"----"+name+"-------"+username);
        guestbookService.addGuestbook(comment,stars,username,name);
        List<guestbook> guest=guestbookService.findGuest(name);
        System.out.println(guest);
        art painting=guestbookService.findPictureBypaintsName(name);
        model.addAttribute("painting",painting);
        model.addAttribute("guestbook",guest);
        model.addAttribute("username",username);
        return "index";
    }
    @GetMapping(value = "deleteComments")
    public String toDeleteComments(@RequestParam("id") int id,
                                   @RequestParam("p_id") int p_id,
                                   RedirectAttributes attr)
    {
        guestbookService.deletePaintsById(id);
        attr.addAttribute("id",p_id);
        return "redirect:/comment";
    }
    @GetMapping(value = "/returnHome")
    public String toReturnHome(){
        return "home";
    }
}
