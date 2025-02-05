package com.wafa.ms_order.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class OrderCreationListener {

    @TransactionalEventListener
    public void publishToKafka(OrderCreationEvent event) {
        var order = event.savedOrder();
        // Send to kafka
    }
}
