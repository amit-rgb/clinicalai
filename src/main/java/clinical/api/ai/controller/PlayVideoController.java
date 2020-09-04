package clinical.api.ai.controller;

import clinical.api.ai.mapper.Candidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayVideoController {


    @GetMapping("/playvideo")
    public String login(Model model)
    {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "playvideo";
    }
}
