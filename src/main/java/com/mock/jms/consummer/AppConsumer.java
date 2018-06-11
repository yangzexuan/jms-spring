package com.mock.jms.consummer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

//        ProducerServiceImpl service = context.getBean(ProducerServiceImpl.class);
//
//        for (int i = 0; i < 100; i++) {
//            service.sendmsg("消息msg"+i);
//        }
//        context.close();
    }

}
