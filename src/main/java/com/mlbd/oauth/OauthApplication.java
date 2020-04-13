package com.mlbd.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @SpringBootApplication
public class OauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

    @GetMapping("/messages")
    public ResponseEntity<String> getMessage(){
	    return ResponseEntity.ok("Hello!");
    }

	@GetMapping("/")
	public String client() { return "client"; }

	@GetMapping("/facebook/callback")
	public String callback() { return "callback_page"; }
}
