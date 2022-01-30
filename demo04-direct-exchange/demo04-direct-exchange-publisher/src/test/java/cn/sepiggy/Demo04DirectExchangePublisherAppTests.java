package cn.sepiggy;

import cn.sepiggy.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo04DirectExchangePublisherAppTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void publish() {
        // 这里的 routine_key 用的是队列名
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE_NAME, RabbitConfig.DIRECT_QUEUE_NAME1, "这条消息发给队列1");
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE_NAME, RabbitConfig.DIRECT_QUEUE_NAME2, "这条消息发给队列2");
    }
}
