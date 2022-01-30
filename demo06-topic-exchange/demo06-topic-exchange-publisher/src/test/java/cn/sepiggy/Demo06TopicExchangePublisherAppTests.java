package cn.sepiggy;

import cn.sepiggy.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo06TopicExchangePublisherAppTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void testPublish() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE_NAME, "xiaomi.news", "小米新闻");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE_NAME, "huawei.news", "华为新闻");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE_NAME, "huawei.phone.news", "华为手机新闻");
    }
}
