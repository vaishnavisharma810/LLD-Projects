package service.impl;

import dao.TransactionDao;
import dao.WalletDao;
import enums.PaymentModeEnum;
import exception.UserNotFoundException;
import model.Wallet;
import service.PaymentMethodService;
import service.WalletService;

import java.math.BigDecimal;
import java.util.Objects;

public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;
    private TransactionDao transactionDao;

    public WalletServiceImpl(final WalletDao walletDao, final TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public String addMoney(final String username, final BigDecimal amount, final String paymentMode) {
        PaymentMethodService payment;
        if(paymentMode.equals((PaymentModeEnum.CREDIT_CARD).toString())) {
            payment = new CCPaymentImpl();
        } else if(paymentMode.equals((PaymentModeEnum.DEBIT_CARD).toString())) {
            payment = new DCPaymentImpl();
        } else if (paymentMode.equals((PaymentModeEnum.UPI).toString())) {
            payment = new UPIPaymentImpl();
        } else {
            return "NOT A VALID PAYMENT MODE";
        }
        if(!payment.getMoney(amount, username)) {
            return "MONEY INSUFFICIENT";
        }
        return walletDao.addMoney(username, amount);
    }

    @Override
    public String transferMoney(final String sender, final String recipient, final BigDecimal amount, final String paymentMode) throws UserNotFoundException{
        if(Objects.isNull(sender)) {
            throw new UserNotFoundException(sender + " not registered with Flipkart wallet");
        } else if(Objects.isNull(recipient)) {
            throw new UserNotFoundException(recipient + " not registered with Flipkart wallet");
        }
        walletDao.sendMoney(sender, recipient, amount);
        PaymentModeEnum paymentModeEnum;
        if(paymentMode.equals((PaymentModeEnum.UPI).toString())) {
            paymentModeEnum = PaymentModeEnum.UPI;
        } else if(paymentMode.equals((PaymentModeEnum.CREDIT_CARD).toString())) {
            paymentModeEnum = PaymentModeEnum.CREDIT_CARD;
        } else {
            paymentModeEnum = PaymentModeEnum.DEBIT_CARD;
        }
        return transactionDao.recordTransaction(sender, recipient, amount, paymentModeEnum);
    }

    @Override
    public BigDecimal fetchBalance(final String username) throws UserNotFoundException {
        if(Objects.isNull(username)) {
            throw new UserNotFoundException("User not registered with Flipkart wallet");
        }
        return walletDao.fetchBalance(username);
    }
}
