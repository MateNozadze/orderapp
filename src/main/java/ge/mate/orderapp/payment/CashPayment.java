package ge.mate.orderapp.payment;

import ge.mate.orderapp.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CashPayment implements PaymentProcessor{
    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CASH;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        System.out.println("Processing cash payment for amount: " + amount);
    }
}
