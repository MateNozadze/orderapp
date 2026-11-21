package ge.mate.orderapp.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class OrderItem {

    private String productName;
    private BigDecimal unitPrice;
    private int quantity;

    public OrderItem(String productName,BigDecimal unitPrice,int quantity) {
        if (productName == null || unitPrice == null || quantity <= 0)
            throw new IllegalArgumentException("Invalid order item");

        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
