package clinical.api.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model){
        return "home";
    }

    @GetMapping("/aboutus")
    public String getAboutUs(Model model){
        return "aboutus";
    }
}
