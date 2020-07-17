package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController{
    ArrayList<Guestbook> allGuestbook = new ArrayList<Guestbook>();



    @RequestMapping("/")
    public String loadGuestForm(Model model){
        model.addAttribute("guestbook", new Guestbook());
        return "addGuestbook";
    }
    @PostMapping("/confirmGuestbook")
    public String confirmGuestbook(@ModelAttribute Guestbook guestbook,Model model)
    {
        allGuestbook.add(guestbook);
        model.addAttribute("allGuestbook",allGuestbook);
        return "listAll";
    }
    @RequestMapping("/listAll")
    public String listAllGuestbook (Model model)
    {
        model.addAttribute("allGuestbook",allGuestbook);
        return "listAll";
    }


        }
