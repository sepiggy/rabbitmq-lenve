package cn.sepiggy.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "demo02_queue";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }
}
