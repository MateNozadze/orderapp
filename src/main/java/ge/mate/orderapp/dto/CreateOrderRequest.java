package ge.mate.orderapp.dto;

import ge.mate.orderapp.enums.DiscountType;
import ge.mate.orderapp.enums.PaymentType;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderRequest(
        List<OrderItemRequest> items,
        DiscountType discountType,
        PaymentType paymentType
) {
    public record OrderItemRequest(
            String productName,
            BigDecimal unitPrice,
            int quantity
    ) {
    }
}