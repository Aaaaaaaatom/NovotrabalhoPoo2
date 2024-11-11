package com.example.SwiftTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUser(@RequestParam String fullName,
                               @RequestParam String email,
                               @RequestParam String password) {
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/login";
    }
}
