package cn.sepiggy.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 消息队列名称
    public static final String QUEUE_NAME = "demo01_queue";

    @Bean
    Queue queue() {
        // 1. 第一个参数是队列的名字
        // 2. 第二个参数是持久化
        // 3. 该队列是否具有排他性，有排他性的队列只能被创建其的 Connection 处理
        // 4. 如果该队列没有消费者，那么是否自动删除该队列
        return new Queue(QUEUE_NAME, true, false, false);
    }
}
