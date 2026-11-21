package ge.mate.orderapp.event;

import ge.mate.orderapp.enums.PaymentType;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        if (event == null){
            return;
        }
        System.out.println("Notification sent: Order #" + event.orderId()
                + " paid via " + event.paymentType()
                + " | Final amount: " + event.finalAmount());
    }
}
