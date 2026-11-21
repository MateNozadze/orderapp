package ge.mate.orderapp.payment;

import ge.mate.orderapp.enums.PaymentType;

import java.math.BigDecimal;

public interface PaymentProcessor {

    PaymentType getPaymentType();
    void processPayment(BigDecimal amount);
}
