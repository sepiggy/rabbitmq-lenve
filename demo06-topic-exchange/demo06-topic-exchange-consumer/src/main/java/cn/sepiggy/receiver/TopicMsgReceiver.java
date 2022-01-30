package cn.sepiggy.receiver;

import cn.sepiggy.config.RabbitTopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 定义三个消费者
 */
@Component
public class TopicMsgReceiver {

    @RabbitListener(queues = RabbitTopicConfig.HUAWEI_QUEUE_NAME)
    public void huawei(String msg) {
        System.out.println("huawei = " + msg);
    }

    @RabbitListener(queues = RabbitTopicConfig.XIAOMI_QUEUE_NAME)
    public void xiaomi(String msg) {
        System.out.println("xiaomi = " + msg);
    }

    @RabbitListener(queues = RabbitTopicConfig.PHONE_QUEUE_NAME)
    public void phone(String msg) {
        System.out.println("phone = " + msg);
    }
}
