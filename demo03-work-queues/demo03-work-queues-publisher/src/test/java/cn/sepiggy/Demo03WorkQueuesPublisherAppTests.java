package cn.sepiggy;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo03WorkQueuesPublisherAppTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	void publish() {
		// 一次性向消息队列发送 20 条消息
		for (int i = 0; i < 20; i++) {
			rabbitTemplate.convertAndSend(Demo03WorkQueuesPublisherApp.QUEUE_NAME, "hello sepiggy: " + i);
		}
	}
}
