package dao;

import model.User;
import model.Wallet;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public class WalletDao {
    private final HashMap<String, Wallet> usersWallet;

    public WalletDao() {
        this.usersWallet = new HashMap<>();
    }

    //fetchBalance() -> credit and debit both transactions
    public BigDecimal fetchBalance(final String username) {
        if(!usersWallet.containsKey(username)) {
            System.out.println("No wallet with username: " + username + " kindly add money");
            return null;
        }
        Wallet wallet = usersWallet.get(username);
        return wallet.getBalance();
    }

    //SendMoney() -> to any recipient
    public void sendMoney(final String sender, final String recipient, final BigDecimal amount) {
        if(!usersWallet.containsKey(sender)) {
            System.out.println("No sender with username: "+ sender + " is present");
            return;
        } else if(!usersWallet.containsKey(recipient)) {
            System.out.println("No recipient with username: "+ recipient + " is present");
            return;
        } else {
            final Wallet senderWallet = usersWallet.get(sender);
            final BigDecimal senderCurrBalance = senderWallet.getBalance();
            if(senderCurrBalance.compareTo(amount) < 0) {
                System.out.println("Insufficient balance");
                return;
            }
            final Wallet recipientWallet = usersWallet.get(recipient);
            recipientWallet.setBalance(recipientWallet.getBalance().add(amount));
            senderWallet.setBalance(senderWallet.getBalance().subtract(amount));
            usersWallet.put(recipient, recipientWallet);
            usersWallet.put(sender, senderWallet);
            System.out.println("Money sent to: " + recipient + " and deducted from " + sender + " account.");
            System.out.println(sender + " current balance is: " + senderWallet.getBalance());
        }
    }

    //addMoney() -> from credit, debit cards and upi
    public String addMoney(final String username, final BigDecimal amount) {
        if (usersWallet.isEmpty() || !usersWallet.containsKey(username)) {
            User user = new User();
            user.setName(username);
            user.setMobileNumber(0000);
            user.setUserId();
            Wallet newWallet = new Wallet();
            newWallet.setBalance(BigDecimal.valueOf(100));
            newWallet.setUser(user);
            usersWallet.put(username, newWallet);
        }
        final Wallet wallet = usersWallet.get(username);
        System.out.println("Wallet of user: " + username + " current balance is: " + wallet.getBalance());
        if(amount.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Amount should be more than 0!!!");
            return "ADD MORE AMOUNT";
        }
        wallet.setBalance(amount.add(wallet.getBalance()));
        System.out.println("Added amount " + amount +" , now your balance is: " + wallet.getBalance());
        usersWallet.put(username, wallet);
        return "SUCCESS";
    }
}
