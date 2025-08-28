package service;

import java.math.BigDecimal;

public interface PaymentMethodService {
    public Boolean getMoney(BigDecimal amount, String username);
}
