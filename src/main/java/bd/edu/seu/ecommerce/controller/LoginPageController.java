package bd.edu.seu.ecommerce.controller;

import bd.edu.seu.ecommerce.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    @GetMapping("/")
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

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard" ;
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("member") User user) {
        return "redirect:/dashboard";
    }




}
