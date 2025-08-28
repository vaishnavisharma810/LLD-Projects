package dao;

import model.User;
import utils.IDGenerator;
import java.util.HashMap;

public class UserDao {

    private HashMap<Integer, User> registeredUser;

    public UserDao() {
        this.registeredUser = new HashMap<>();
    }

    public User registerUser(int mobileNumber, String userName) {
        if(registeredUser.containsKey(mobileNumber)) {
            System.out.println("A user with mobile number: " + mobileNumber + " already exists");
            return null;
        } else {
            User user = new User();
            user.setMobileNumber(mobileNumber);
            user.setName(userName);
            user.setUserId();
            registeredUser.put(mobileNumber, user);
            return user;
        }
    }
}
