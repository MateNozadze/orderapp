package ge.mate.orderapp.strategy;

import ge.mate.orderapp.enums.DiscountType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class DiscountStrategyRegistry {

    private final Map<DiscountType, DiscountStrategy> discountStrategies;

    public DiscountStrategyRegistry(List<DiscountStrategy> strategyList) {
        this.discountStrategies = new EnumMap<>(DiscountType.class);
        for (DiscountStrategy strategy : strategyList) {
            this.discountStrategies.put(strategy.getType(), strategy);
        }
    }

    public DiscountStrategy getStrategy(DiscountType discountType) {
        if (discountType == null) {
            throw new IllegalArgumentException("Discount type must not be null");
        }

        DiscountStrategy strategy = discountStrategies.get(discountType);
        if (strategy == null) {
            throw new IllegalArgumentException("Discount strategy not found for type: " + discountType);
        }

        return strategy;
    }
}