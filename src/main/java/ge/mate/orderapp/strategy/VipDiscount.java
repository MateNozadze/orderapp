package ge.mate.orderapp.strategy;

import java.math.BigDecimal;

public class VipDiscount implements DiscountStrategy{
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }

    @Override
    public DiscountType getType() {
        return DiscountType.VIP;
    }
}
