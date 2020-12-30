package RabbitMqTest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yml
 * @time: 2020/12/30
 */

@RabbitListener(queues = "itCast")
@Component
public class RabbitMqConsumer {
    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("直接模式消费消息: " + message);
    }

}
