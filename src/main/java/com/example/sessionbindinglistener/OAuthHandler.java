package com.example.sessionbindinglistener;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OAuthHandler {

    public ResponseEntity<Post> fetchResponse(String code){
        String url = "https://github.com/login/oauth/access_token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> map = new HashMap<>();
        map.put("client_id", "Iv1.0578e89ced9091d9");
        //Pretend this is a safe datastore
        map.put("client_secret", System.getenv("client_secret"));
        map.put("code", code);

        HttpEntity<Map<String,String>> request = new HttpEntity<>(map,headers);

        return restTemplate.postForEntity(url, request, Post.class);
    }

}
