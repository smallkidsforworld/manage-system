package com.transwrap.transwrap.test;

import com.transwrap.transwrap.configuration.RabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: yml
 * @time: 2020/11/1
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MQProducer {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void Producer_topics_springbootTest() {

        //使用rabbitTemplate发送消息
        String message = "send email message to user";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);

    }

}
