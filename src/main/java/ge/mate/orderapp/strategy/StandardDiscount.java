package ge.mate.orderapp.strategy;

import java.math.BigDecimal;

public class StandardDiscount implements DiscountStrategy{
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.95));
    }

    @Override
    public DiscountType getType() {
        return DiscountType.STANDARD;
    }
}
