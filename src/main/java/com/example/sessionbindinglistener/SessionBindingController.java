package com.example.sessionbindinglistener;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class SessionBindingController {
    private final ActiveUserStore activeUserStore = new ActiveUserStore();
    private final OAuthHandler oauth = new OAuthHandler();


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", activeUserStore.getUsers());
        return "index";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "redirect:/secret";
    }

    @GetMapping("/allLoggedIn")
    public String all(){
        return "who-is-logged-in";
    }


    @GetMapping("/secret")
    public String secret(@RequestParam String code){
        ResponseEntity<Post> response = oauth.fetchResponse(code);
        System.out.println(response.toString());
        return "secret";
    }

    @PostMapping("/github-webhook")
    public String webhook(){
        return "index";
    }
}
