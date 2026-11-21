package ge.mate.orderapp.service;

import ge.mate.orderapp.enums.DiscountType;
import ge.mate.orderapp.enums.PaymentType;
import ge.mate.orderapp.event.OrderCreatedEvent;
import ge.mate.orderapp.model.Order;
import ge.mate.orderapp.model.OrderItem;
import ge.mate.orderapp.payment.PaymentProcessor;
import ge.mate.orderapp.payment.PaymentRegistry;
import ge.mate.orderapp.strategy.DiscountStrategy;
import ge.mate.orderapp.strategy.DiscountStrategyRegistry;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final DiscountStrategyRegistry discountStrategyRegistry;
    private final PaymentRegistry paymentRegistry;
    private final ApplicationEventPublisher eventPublisher;

    public OrderService(DiscountStrategyRegistry discountStrategyRegistry, PaymentRegistry paymentRegistry, ApplicationEventPublisher eventPublisher) {
        this.discountStrategyRegistry = discountStrategyRegistry;
        this.paymentRegistry = paymentRegistry;
        this.eventPublisher = eventPublisher;
    }

    public Order createOrder(List<OrderItem> items, DiscountType discountType, PaymentType paymentType){

        if (items == null || items.isEmpty())
            throw new IllegalArgumentException("Items list cannot be null or empty");

        Order order = new Order(paymentType);
        for (OrderItem item : items) {
            order.addOrderItem(item);
        }

        BigDecimal subtotal = order.calculateSubtotal();
        DiscountStrategy discountStrategy = discountStrategyRegistry.getStrategy(discountType);
        BigDecimal finalAmount = discountStrategy.applyDiscount(subtotal);
        order.setFinalAmount(finalAmount);

        PaymentProcessor paymentProcessor = paymentRegistry.getPaymentProcessor(paymentType);
        paymentProcessor.processPayment(order.getFinalAmount());
        order.markAsPaid();

        eventPublisher.publishEvent(new OrderCreatedEvent(order.getItemId(), order.getFinalAmount(), paymentType));

        return order;
    }
}
