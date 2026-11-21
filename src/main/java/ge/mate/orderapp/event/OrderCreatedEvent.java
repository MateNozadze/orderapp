package ge.mate.orderapp.event;

import ge.mate.orderapp.enums.PaymentType;

import java.math.BigDecimal;

public record OrderCreatedEvent(Long orderId, BigDecimal finalAmount, PaymentType paymentType) {

}
