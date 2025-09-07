package dao;

import model.Interviewer;
import utils.UserIDGenerator;
import java.util.HashMap;
import java.util.List;
import static utils.Constants.FAILURE;
import static utils.Constants.SUCCESS;

public class InterviewerDao {
    private final HashMap<Integer, Interviewer> interviewerMap;

    public InterviewerDao() {
        this.interviewerMap = new HashMap<>();
    }

    public String registerInterviewer(final String interviewerName, final List<Integer> timeslots,
                                    final List<String> skills) {
        int candidateID = UserIDGenerator.genrateUserID();
        Interviewer interviewer = new Interviewer();
        interviewer.setUserName(interviewerName);
        interviewer.setUserID(candidateID);
        interviewer.setTimeslotList(timeslots);
        interviewer.setSkills(skills);
        interviewerMap.put(candidateID, interviewer);
        return SUCCESS;
    }

    public String addTimeslot(final Integer interviewerID, final Integer timeslot) {
        if(!interviewerMap.containsKey(interviewerID)) {
            System.out.println("No interviewer registered with ID: " + interviewerID);
            return FAILURE;
        }
        Interviewer interviewer = interviewerMap.get(interviewerID);
        List<Integer> timeslotList = interviewer.getTimeslotList();
        if(timeslotList.contains(timeslot)) {
            System.out.println("Already given timeslot available!");
            return FAILURE;
        }
        timeslotList.add(timeslot);
        interviewer.setTimeslotList(timeslotList);
        interviewerMap.put(interviewerID, interviewer);
        return SUCCESS;
    }

    public HashMap<Integer, Interviewer> getInterviewerList() {
        return this.interviewerMap;
    }

    public List<Integer> getAvailableSlots() {

    }
}
