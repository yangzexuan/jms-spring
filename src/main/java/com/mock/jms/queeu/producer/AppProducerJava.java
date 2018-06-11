package com.mock.jms.queeu.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducerJava
{

    private static final String URL = "tcp://localhost:61616";
    private static final String queueName = "QueueTest";
    public static void main(String[] args) throws JMSException {

//        1、创建connectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
//        2、创建connection
        Connection connection = connectionFactory.createConnection();
//        3、启动连接
        connection.start();
//         4、创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        创建一个目标
        Destination queue = session.createQueue(queueName);

//      创建生成者
        MessageProducer producer = session.createProducer(queue);


        for (int i = 0; i < 10; i++) {
//        创建消息
            TextMessage textMessage = session.createTextMessage("队列消息" + i);
//            发送消息
            producer.send(textMessage);
        }
//关闭连接
        connection.close();


    }
}
