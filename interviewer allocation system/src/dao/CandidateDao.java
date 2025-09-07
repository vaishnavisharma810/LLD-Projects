package dao;

import model.Candidate;
import utils.UserIDGenerator;

import java.util.HashMap;
import java.util.List;

import static utils.Constants.SUCCESS;

public class CandidateDao {
    private HashMap<Integer, Candidate> candidateMap;

    public CandidateDao() {
        this.candidateMap = new HashMap<>();
    }

    public String registerCandidate(final String candidateName, final Integer yearOfExperience,
                                    final List<String> skills) {
        int candidateID = UserIDGenerator.genrateUserID();
        Candidate candidate = new Candidate();
        candidate.setUserName(candidateName);
        candidate.setUserID(candidateID);
        candidate.setYearsOfExperience(yearOfExperience);
        candidate.setSkills(skills);
        candidateMap.put(candidateID, candidate);
        return SUCCESS;
    }

    public HashMap<Integer, Candidate> getCandidateList() {
        return this.candidateMap;
    }
}
