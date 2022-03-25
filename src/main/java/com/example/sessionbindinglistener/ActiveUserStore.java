package com.example.sessionbindinglistener;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class ActiveUserStore {

    public List<String> users;

    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

    @Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }

    public List<String> getUsers(){
        return users;
    }



    // standard getter and setter
}
