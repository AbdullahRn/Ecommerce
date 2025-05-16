package bd.edu.seu.ecommerce.controller;

import bd.edu.seu.ecommerce.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("member", new User());
        return "index";
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
