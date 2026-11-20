package ge.mate.orderapp.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal amount);
    DiscountType getType();
}
