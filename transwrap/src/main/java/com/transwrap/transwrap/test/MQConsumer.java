package com.transwrap.transwrap.test;

import com.rabbitmq.client.Channel;
import com.transwrap.transwrap.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @description:
 * @author: yml
 * @time: 2020/11/1
 */

public class MQConsumer {
    @RabbitListener(queues = {RabbitConfig.QUEUE_INFORM_EMAIL})
    public void receive_email(Object msg, Message message, Channel channel){
        System.out.println("QUEUE_INFORM_EMAIL msg"+msg);
    }
    //监听sms队列
    @RabbitListener(queues = {RabbitConfig.QUEUE_INFORM_SMS})
    public void receive_sms(Object msg, Message message, Channel channel){
        System.out.println("QUEUE_INFORM_SMS msg"+msg);
    }
}
