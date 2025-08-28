package service;

import model.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransaction(final String username, final String filterType, final String sortingType);
}
