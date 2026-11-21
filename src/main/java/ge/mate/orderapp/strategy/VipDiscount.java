package ge.mate.orderapp.strategy;

import ge.mate.orderapp.enums.DiscountType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
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
