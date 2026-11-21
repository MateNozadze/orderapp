package ge.mate.orderapp.controller;

import ge.mate.orderapp.dto.CreateOrderRequest;
import ge.mate.orderapp.model.Order;
import ge.mate.orderapp.model.OrderItem;
import ge.mate.orderapp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        List<OrderItem> items = request.items().stream()
                .map(item -> new OrderItem(item.productName(), item.unitPrice(), item.quantity()))
                .toList();

        Order createdOrder = orderService.createOrder(
                items,
                request.discountType(),
                request.paymentType()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }
}