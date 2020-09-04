package clinical.api.ai.controller;

import clinical.api.ai.handler.CandidateHandler;
import clinical.api.ai.mapper.Candidate;
import clinical.api.ai.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private CandidateHandler candidateHandler;

    @GetMapping("/register")
    public String register(Model model) {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "register";
    }

    @PostMapping("/registercandidate")
    public String registerCandidate(Candidate candidate, Model model) {
        candidateHandler.saveCandidate(candidate);
        System.out.println("Inside Registration");
        return "home";
    }
}
