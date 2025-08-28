package service.impl;

import service.PaymentMethodService;

import java.math.BigDecimal;

public class DCPaymentImpl implements PaymentMethodService {
    @Override
    public Boolean getMoney(BigDecimal amount, String username) {
        return true;
    }
}
