package model;

public class Interview {
    private Integer interviewID;
    private String timeslot;
    private Candidate candidate;
    private Interviewer interviewer;

    public Integer getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(Integer interviewID) {
        this.interviewID = interviewID;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public Candidate getInterviewee() {
        return candidate;
    }

    public void setInterviewee(Candidate candidate) {
        this.candidate = candidate;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
}
