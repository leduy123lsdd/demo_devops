package com.devops.demo_devops.KeyCloakRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class KeyCloakRestService {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/login")
    public String login(@RequestBody Map<String, String> body ) {
        String token_url = "http://localhost:8080/auth/realms/client-realm/protocol/openid-connect/token";
        String username = body.get("username");
        String password = body.get("password");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username",username);
        map.add("password",password);
        map.add("client_id","application1");
        map.add("grant_type","password");

        HttpEntity<MultiValueMap<String, String>> requestHeader = new HttpEntity<>(map, new HttpHeaders());

        return restTemplate.postForObject(token_url, requestHeader, String.class);

    }

//    @PostMapping("/logout")
//    public String logout(){
//
//    }
}
