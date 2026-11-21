package ge.mate.orderapp.payment;


import ge.mate.orderapp.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentRegistry {

    private final Map<PaymentType, PaymentProcessor> paymentProcessors;

    public PaymentRegistry(List<PaymentProcessor> processorList) {
       this.paymentProcessors = new EnumMap<>(PaymentType.class);
       for (PaymentProcessor processor : processorList) {
           this.paymentProcessors.put(processor.getPaymentType(), processor);
       }
    }

    public PaymentProcessor getPaymentProcessor(PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type must not be null");
        }
        PaymentProcessor processor = paymentProcessors.get(paymentType);
        if (processor == null) {
            throw new IllegalArgumentException("Payment processor not found for payment type: " + paymentType);
        }
        return processor;
    }

}
