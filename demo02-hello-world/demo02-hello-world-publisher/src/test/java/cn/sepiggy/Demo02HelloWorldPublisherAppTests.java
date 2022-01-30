package cn.sepiggy;

import cn.sepiggy.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo02HelloWorldPublisherAppTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	/**
	 * 使用 Java 代码向消息队列发送消息
	 */
	@Test
	void publish() {
		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, "hello world by rabbitmq");
	}

}
