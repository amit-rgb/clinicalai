package clinical.api.ai.controller;

import clinical.api.ai.handler.CandidateHandler;
import clinical.api.ai.mapper.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private CandidateHandler candidateHandler;

    @GetMapping("/login")
    public String login(Model model)
    {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "login";
    }

    @GetMapping("/logincandidate")
    public String loginCandidate(Candidate candidate, Model model){
        Candidate dbCandidate = candidateHandler.getCandidate(candidate);
        if(candidate.getUserName().equalsIgnoreCase(dbCandidate.getUserName())){
            System.out.println("Authentiaction is successful");
            return "home";
        }
        return null;

    }
}
