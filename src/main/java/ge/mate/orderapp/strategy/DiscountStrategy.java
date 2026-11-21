package ge.mate.orderapp.strategy;

import ge.mate.orderapp.enums.DiscountType;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal amount);
    DiscountType getType();
}
