package utils;

public class InterviewIDGenerator {
    private static int userID = 6000;
    public static int genrateUserID() {
        return userID++;
    }
}
