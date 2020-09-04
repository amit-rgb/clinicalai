package clinical.api.ai.repository;

import clinical.api.ai.mapper.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    public Candidate findCandidateByUserName(String userName);
}
