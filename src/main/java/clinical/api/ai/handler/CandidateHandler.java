package clinical.api.ai.handler;

import clinical.api.ai.mapper.Candidate;
import clinical.api.ai.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CandidateHandler {

    @Autowired
    private CandidateRepository candidateRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveCandidate(Candidate candidate) {
        String encodedPassword = bCryptPasswordEncoder.encode(candidate.getPassword());
        candidate.setPassword(encodedPassword);
        candidateRepository.save(candidate);
    }

    public Candidate getCandidate(Candidate candidate){
        Candidate dbCandidate = candidateRepository.findCandidateByUserName(candidate.getUserName());
        return dbCandidate;
    }
}
