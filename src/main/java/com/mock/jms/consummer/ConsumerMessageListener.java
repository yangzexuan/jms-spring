package com.mock.jms.consummer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            String text = textMessage.getText();
            System.out.println("接收消息："+text);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
