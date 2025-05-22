package bd.edu.seu.ecommerce.controller;

import bd.edu.seu.ecommerce.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    @GetMapping("/submit")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/dashboard";
        }
        else{
            model.addAttribute("user", new User());
            return "redirect:/";
        }
    }



    @GetMapping("/login")
    public String submit(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }




}
