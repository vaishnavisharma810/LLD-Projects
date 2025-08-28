package service;

import exception.UserNotFoundException;

import java.math.BigDecimal;

public interface WalletService {
    public String addMoney(final String username, final BigDecimal amount, final String paymentMode);
    public String transferMoney(final String sender, final String recipient, final BigDecimal amount, final String paymentMode) throws UserNotFoundException;
    public BigDecimal fetchBalance(final String username) throws UserNotFoundException;

}
