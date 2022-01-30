package cn.sepiggy;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Demo03WorkQueuesPublisherApp {

    public static final String QUEUE_NAME = "demo03_queue";

    @Bean
    Queue helloWorldQueue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo03WorkQueuesPublisherApp.class, args);
    }
}
