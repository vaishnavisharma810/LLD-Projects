package dao;

import model.Candidate;
import model.Interview;
import model.Interviewer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InterviewDao {
    private final HashMap<Candidate, Interview> interviewMap;
    private CandidateDao candidateDao;
    private InterviewerDao interviewerDao;

    public InterviewDao() {
        this.interviewMap = new HashMap<>();
    }

    public String setInterview(final Integer candidateID) {
        HashMap<Integer, Candidate> candidateList = candidateDao.getCandidateList();
        if(!candidateList.containsKey(candidateID)) {
            System.out.println("No candidate with candidate ID: " +candidateID + " found");
            return "FAILURE";
        }
        Candidate candidate = candidateList.get(candidateID);
        List<String> candidateSkills = candidate.getSkills();
        HashMap<Integer, Interviewer> interviewerList = interviewerDao.getInterviewerList();

//        Optional<Interviewer> matched = interviewerDao.getInterviewerList().values().stream()
//                .filter(interviewer -> !interviewer.getAvailableSlots().isEmpty())
//                .filter(interviewer -> interviewer.getSkills().stream()
//                        .anyMatch(skill -> candidate.getSkills().contains(skill)))
//                .findAny();
        return "";
    }
}
