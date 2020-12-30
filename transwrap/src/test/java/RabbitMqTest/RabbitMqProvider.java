package RabbitMqTest;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description:
 * @author: yml
 * @time: 2020/12/30
 */

@SpringBootTest
public class RabbitMqProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接模式
     */
    @Test
    public void sendMessage1() {
        // 序列, 内容
        rabbitTemplate.convertAndSend("itCast", "直接模式测试");
    }

}
