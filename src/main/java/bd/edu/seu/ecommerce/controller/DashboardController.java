package bd.edu.seu.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/")
    public String dashboardPage() {
        return "dashboard" ;
    }

    @GetMapping("/dashboard")
    public String dashboardRedirect() {
        return "redirect:/" ;
    }
}
