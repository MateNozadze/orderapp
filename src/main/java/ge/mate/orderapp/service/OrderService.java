package ge.mate.orderapp.service;

import ge.mate.orderapp.enums.DiscountType;
import ge.mate.orderapp.enums.PaymentType;
import ge.mate.orderapp.model.Order;
import ge.mate.orderapp.model.OrderItem;
import ge.mate.orderapp.payment.PaymentRegistry;
import ge.mate.orderapp.strategy.DiscountStrategyRegistry;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
