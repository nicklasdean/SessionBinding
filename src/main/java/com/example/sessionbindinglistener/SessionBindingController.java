package com.example.sessionbindinglistener;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class SessionBindingController {
    ActiveUserStore activeUserStore = new ActiveUserStore();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", activeUserStore.getUsers());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "redirect:/secret";
    }

    @GetMapping("allUsers")
    public String all(){
        return "who-is-logged-in";
    }


    @GetMapping("/secret")
    public String secret(){
        return "secret";
    }
}
