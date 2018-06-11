package com.mock.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");

        ProducerServiceImpl service = context.getBean(ProducerServiceImpl.class);

        for (int i = 0; i < 100; i++) {
            service.sendmsg("消息msg"+i);
        }
        context.close();
    }

}
