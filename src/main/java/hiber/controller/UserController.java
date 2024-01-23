package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        Long userId = userService.getUserIdByEmail(principal.getName());
        User user = userService.findUserById(userId);
//        User user = userService.findByUserEmail(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}


