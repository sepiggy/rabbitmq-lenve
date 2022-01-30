package cn.sepiggy;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Demo03WorkQueuesConsumerApp {

    public static final String QUEUE_NAME = "demo03_queue";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    // 两个消费者监听同一个消息队列
    @RabbitListener(queues = QUEUE_NAME)
    public void handleMsg(String msg) {
        System.out.println("msg = " + msg);
    }

    // RabbitListener#concurrency 属性指的是并发数量，即这个消费者将开启 20 个子线程消费消息
    @RabbitListener(queues = QUEUE_NAME, concurrency = "20")
    public void handleMsg2(String msg) {
        System.out.println("msg2 = " + msg + "--->" + Thread.currentThread().getName()) ;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo03WorkQueuesConsumerApp.class, args);
    }
}
