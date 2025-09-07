package utils;

public class UserIDGenerator {

    private static int userID = 1000;
    public static int genrateUserID() {
        return userID++;
    }
}
