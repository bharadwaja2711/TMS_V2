package com.klef.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @Autowired
    private ReCaptchaValidationService validator;

    @Autowired
    private RegistrationRepository registrationRepository;

    @RequestMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("registrationEntity", new RegistrationEntity());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationEntity") RegistrationEntity registrationEntity,
                           @RequestParam(name = "g-recaptcha-response") String captcha, Model model) {
        try {
            if (validator.validateCaptcha(captcha)) {
                registrationRepository.save(registrationEntity);
                model.addAttribute("registrationEntity", new RegistrationEntity());
                model.addAttribute("message", "Registration successful!!");
            } else {
                model.addAttribute("message", "Please verify captcha.");
            }
        } catch (Exception e) {
            model.addAttribute("message", "Error occurred during registration.");
        }

        return "register";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
