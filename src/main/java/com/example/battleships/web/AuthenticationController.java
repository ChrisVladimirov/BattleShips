package com.example.battleships.web;

import com.example.battleships.models.DTOs.dataImport.UserLoginDTO;
import com.example.battleships.models.DTOs.dataImport.UserRegisterDTO;
import com.example.battleships.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ModelAttribute("registrationDTO")
    public UserRegisterDTO initRegistrationModel() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO registrationDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.authenticationService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/register";
        }
        this.authenticationService.register(registrationDTO);
        return "redirect:/login";
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }

        if (!this.authenticationService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes
                    .addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        this.authenticationService.login(loginDTO);
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/";
    }
}
