package com.fundoonotes.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @JmsListener(destination = "fundoo-queue")
    public void receiveMessage(String message) {
        System.out.println("📩 Received from queue: " + message);
    }
}