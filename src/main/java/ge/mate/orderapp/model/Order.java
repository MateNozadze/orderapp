package ge.mate.orderapp.model;

import ge.mate.orderapp.enums.OrderStatus;
import ge.mate.orderapp.enums.PaymentType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order {

    private Long itemId;
    List<OrderItem> orderItems;
    BigDecimal originalAmount;
    BigDecimal finalAmount;
    PaymentType paymentType;
    OrderStatus orderStatus;

    public Order(PaymentType paymentType) {
        this.itemId = ThreadLocalRandom.current().nextLong(100_000L, 1_000_000_000L);
        this.orderItems = new ArrayList<>();
        this.paymentType = paymentType;
        this.orderStatus = OrderStatus.CREATED;
        this.originalAmount = BigDecimal.ZERO;
        this.finalAmount = BigDecimal.ZERO;
    }

    public BigDecimal calculateSubtotal() {
        if (orderItems == null || orderItems.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal subtotal = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            subtotal = subtotal.add(orderItem.getTotalPrice());
        }

        return subtotal;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        if (finalAmount == null || finalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Final amount cannot be null or zero");
        }
        this.finalAmount = finalAmount;
    }

    public void markAsPaid() {
        this.orderStatus = OrderStatus.PAID;
    }

    public void addOrderItem(OrderItem orderItem) {

        if (orderItem==null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItems.add(orderItem);
    }

    public Long getItemId() {
        return itemId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems == null ? Collections.emptyList() : Collections.unmodifiableList(orderItems);
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public BigDecimal getFinalAmount(BigDecimal finalAmount) {
        return this.finalAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }


}
