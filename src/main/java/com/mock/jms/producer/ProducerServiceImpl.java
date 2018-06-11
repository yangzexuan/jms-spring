package com.mock.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;


public class ProducerServiceImpl implements  ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
//    @Resource(name = "queueDestination")
@Resource(name = "topicDestination")
    Destination destination;

    public void sendmsg(final String msg) {

        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                System.out.println("创建消息："+textMessage.getText());

                return textMessage;
            }
        });

        System.out.println("发送消息："+msg);
    }
}
