package com.fundoonotes.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("📤 Sending to queue: " + message);
        jmsTemplate.convertAndSend("fundoo-queue", message);
    }
}