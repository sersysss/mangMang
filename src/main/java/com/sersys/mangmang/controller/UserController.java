package com.sersys.mangmang.controller;

import com.sersys.mangmang.entity.Role;
import com.sersys.mangmang.entity.User;
import com.sersys.mangmang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/")
    public String greeting(Model model) {

        return "greeting";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = (User) userService.loadUserByUsername(user.getEmail());

        if(userFromDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }
        User userToDB = new User();
        userToDB.setLogin(user.getLogin());
        userToDB.setEmail(user.getEmail());
        userToDB.setPassword(passwordEncoder.encode(user.getPassword()));
        userToDB.setActive(true);
        userToDB.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(userToDB);

        return "redirect:/login";
    }
}
