package com.example.demo.controller;

import com.example.demo.db.entity.User;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("loginFormDTO",new LoginFormDTO());
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm(@Validated @ModelAttribute LoginFormDTO loginFormDTO, Model model) {

        //mapiranje dto u pravi objekat
        User user = userService.convertToEntityLogin(loginFormDTO);

        if (userService.isValidUser(user.getUsername(), user.getPassword())) {
            model.addAttribute("message", "Login successful");
            return "index"; // Redirect to a successful login page or dashboard if needed
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "index"; // Stay on the same page but show the error message
        }


    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerFormDTO", new RegisterFormDTO());
        return "register";  // This refers to your Thymeleaf template named "register.html"
    }

    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerDTO") RegisterFormDTO registerFormDTO, Model model) {

        //mapiranje dto u pravi objekat
        userService.register();


        // Custom validation for password match
        if (!registerFormDTO.getPassword().equals(registerFormDTO.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords do not match");
            return "register";
        }

        // You would add additional logic to save the user, handle uniqueness checks, etc.
        // For now, we'll just redirect to a success page.

        model.addAttribute("message","Registration successful");

        return "login";  // Redirect after successful registration
    }


}
