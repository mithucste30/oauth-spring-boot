package com.mlbd.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/")
public class FriendsController {
    @Autowired
    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;

    @GetMapping
    public String friends(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        String [] friends = { "id", "email", "name"};
        User userprofile = facebook.fetchObject("me", User.class, friends);
        model.addAttribute("friends", friends);
        return "friends";
    }
}
