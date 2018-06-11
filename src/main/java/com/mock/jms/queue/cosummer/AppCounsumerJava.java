package com.mock.jms.queue.cosummer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppCounsumerJava
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

//      创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
//        创建监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println("接收消息内容："+text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//关闭连接
//        connection.close();


    }
}
