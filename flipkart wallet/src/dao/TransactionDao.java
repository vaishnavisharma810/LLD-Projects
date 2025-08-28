package dao;

import enums.PaymentModeEnum;
import enums.TransactionTypeEnum;
import model.Transaction;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TransactionDao {
    private final HashMap<String, List<Transaction>> usersTransactions;

    public TransactionDao() {
        this.usersTransactions = new HashMap<>();
    }
    //getAllTransactionsHistory()
    public List<Transaction> getAllTransaction(final String username) {
        if(!usersTransactions.containsKey(username)) {
            System.out.println("No transactions of " + username + " found!!!");
            return new ArrayList<>();
        }
        return usersTransactions.get(username);
    }

    //recordTransaction() -> will be called when send and receive money of wallet is implemented
    public String recordTransaction(final String senderName, final String recipientName, final BigDecimal amount,
                                  final PaymentModeEnum paymentMode) {
        Transaction sendTransaction = new Transaction();
        sendTransaction.setSenderName(senderName);
        sendTransaction.setRecipientName(recipientName);
        sendTransaction.setAmount(amount);
        sendTransaction.setPaymentMode(paymentMode);
        sendTransaction.setTime(Instant.now());
        sendTransaction.setTransactionType(TransactionTypeEnum.DEBITED);

        Transaction receiveTransaction = new Transaction();
        receiveTransaction.setSenderName(senderName);
        receiveTransaction.setRecipientName(recipientName);
        receiveTransaction.setAmount(amount);
        receiveTransaction.setPaymentMode(paymentMode);
        receiveTransaction.setTime(Instant.now());
        receiveTransaction.setTransactionType(TransactionTypeEnum.CREDITED);

        List<Transaction> userSendTransactions = usersTransactions.get(senderName);
        if(Objects.isNull(userSendTransactions)) {
            userSendTransactions = new ArrayList<>();
        }
        List<Transaction> userReceiveTransactions = usersTransactions.get(recipientName);
        if(Objects.isNull(userReceiveTransactions)) {
            userReceiveTransactions = new ArrayList<>();
        }

        userSendTransactions.add(sendTransaction);
        userReceiveTransactions.add(receiveTransaction);

        usersTransactions.put(senderName, userSendTransactions);
        usersTransactions.put(recipientName, userReceiveTransactions);

        return "SUCCESS";
    }
}
