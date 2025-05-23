package bd.edu.seu.ecommerce.controller;

import bd.edu.seu.ecommerce.model.User;
import bd.edu.seu.ecommerce.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String SignUp(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/dashboard";
        }
        else{
            model.addAttribute("user", new User());
            return "signup";
        }

    }



    @PostMapping("/register")
    public String Register(@ModelAttribute User user) {
        System.out.println("It's reaching the controller");
        userService.save(user);

        return "redirect:/dashboard";


    }
}
