package model;

import utils.IDGenerator;

public class User {

    private String name;
    private int mobileNumber;
    private int userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = IDGenerator.generateId();
    }
}
