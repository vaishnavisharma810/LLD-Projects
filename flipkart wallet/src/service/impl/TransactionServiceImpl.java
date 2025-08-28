package service.impl;

import comparator.AmountBasedComparator;
import comparator.TimeBasedComparator;
import dao.TransactionDao;
import model.Transaction;
import service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    //getAllTransactionsHistory()
    // -> sort based on transaction date and amount
    // -> filter based on send or receive
    @Override
    public List<Transaction> getAllTransaction(final String username, final String filterType, final String sortingType) {
        final List<Transaction> transactionList = transactionDao.getAllTransaction(username);
        if (filterType.equals("DEBITED")) {
            if(sortingType.equals("AMOUNT_BASED")) {
                return this.getAllTransactionHelper(transactionList, "DEBITED", "AMOUNT_BASED");
            } else {
                return this.getAllTransactionHelper(transactionList, "DEBITED", "TIME_BASED");
            }
        } else if (filterType.equals("CREDITED")) {
            if(sortingType.equals("AMOUNT_BASED")) {
                return this.getAllTransactionHelper(transactionList, "CREDITED", "AMOUNT_BASED");
            } else {
                return this.getAllTransactionHelper(transactionList, "CREDITED", "TIME_BASED");
            }
        } else
            return transactionList;
    }

    private List<Transaction> getAllTransactionHelper(List<Transaction> transactionList, final String filterType, final String sortingType) {
        List<Transaction> allFilteredTransactions = transactionList.stream().filter(transaction ->
                transaction.getTransactionType().toString().equals(filterType)
        ).toList();
        if (sortingType.equals("AMOUNT_BASED")) {
            allFilteredTransactions.sort(new AmountBasedComparator());
        } else {
            allFilteredTransactions.sort(new TimeBasedComparator());
        }
        return allFilteredTransactions;
    }
}
