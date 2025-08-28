package service.impl;

import service.PaymentMethodService;

import java.math.BigDecimal;

public class UPIPaymentImpl implements PaymentMethodService {
    @Override
    public Boolean getMoney(BigDecimal amount, String username) {
        return true;
    }
}
