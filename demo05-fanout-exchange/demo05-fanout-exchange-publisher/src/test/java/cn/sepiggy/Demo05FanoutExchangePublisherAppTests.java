package cn.sepiggy;

import cn.sepiggy.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo05FanoutExchangePublisherAppTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void publish() {
        rabbitTemplate.convertSendAndReceive(RabbitConfig.FANOUT_EXCHANGE_NAME, null, "hello fanout!");
    }
}
