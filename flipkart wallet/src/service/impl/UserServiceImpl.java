package service.impl;

import dao.UserDao;
import dao.WalletDao;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private WalletDao walletDao;

    public UserServiceImpl(final UserDao userDao, final WalletDao walletDao) {
        this.userDao = userDao;
        this.walletDao = walletDao;
    }

    @Override
    public String registerUser(final String username, final Integer mobileNumber) {
        final User newUser = userDao.registerUser(mobileNumber, username);
        if(Objects.isNull(newUser)) {
            return "FAILURE";
        }
        walletDao.addMoney(username, BigDecimal.valueOf(10.0));
        return "SUCCESS";
    }
}
