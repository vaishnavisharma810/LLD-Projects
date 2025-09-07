package model;

import java.util.List;

public class Interviewer extends User {
    private List<Integer> timeslotList;
    private List<String> skills;

    public List<Integer> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<Integer> timeslotList) {
        this.timeslotList = timeslotList;
    }
}
