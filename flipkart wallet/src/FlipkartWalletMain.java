import dao.TransactionDao;
import dao.UserDao;
import dao.WalletDao;
import exception.UserNotFoundException;
import service.TransactionService;
import service.UserService;
import service.WalletService;
import service.impl.TransactionServiceImpl;
import service.impl.UserServiceImpl;
import service.impl.WalletServiceImpl;

import java.math.BigDecimal;

public class FlipkartWalletMain {
    public static void main(String[] args) throws UserNotFoundException {
        //User should register on flipkart
        UserDao userDao = new UserDao();
        WalletDao walletDao = new WalletDao();
        TransactionDao transactionDao = new TransactionDao();
        UserService userService = new UserServiceImpl(userDao, walletDao);
        TransactionService transactionService = new TransactionServiceImpl(transactionDao);
        WalletService walletService = new WalletServiceImpl(walletDao, transactionDao);

        //Register Users:
        userService.registerUser("Anmol", 8999);
        userService.registerUser("Sid", 9999);
        userService.registerUser("Divya", 7789);

        //Processing 
        walletService.addMoney("Anmol", BigDecimal.valueOf(12.12), "CREDIT_CARD");

        walletService.fetchBalance("Anmol");

        walletService.transferMoney("Anmol","Sid", BigDecimal.valueOf(5.0), "UPI");

        walletService.transferMoney("Anmol","Divya", BigDecimal.valueOf(2.0), "DEBIT_CARD");

        walletService.transferMoney("Divya","Sid", BigDecimal.valueOf(2.0), "CREDIT_CARD");

        walletService.fetchBalance("Sid");

        walletService.fetchBalance("Anmol");

        transactionService.getAllTransaction("Anmol", "SEND","AMOUNT");

        transactionService.getAllTransaction("Divya", "SEND","AMOUNT");

        transactionService.getAllTransaction("Sid", "RECEIVE","AMOUNT");
    }
}