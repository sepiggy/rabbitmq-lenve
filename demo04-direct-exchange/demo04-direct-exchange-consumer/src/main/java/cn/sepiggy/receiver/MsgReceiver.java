package cn.sepiggy.receiver;

import cn.sepiggy.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class MsgReceiver {

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_NAME1)
    public void handleMsg1(String msg) {
        System.out.println("msg1 = " + msg);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_NAME2)
    public void handleMsg2(String msg) {
        System.out.println("msg2 = " + msg);
    }
}
