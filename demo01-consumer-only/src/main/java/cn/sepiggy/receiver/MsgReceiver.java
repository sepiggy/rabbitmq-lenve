package cn.sepiggy.receiver;

import cn.sepiggy.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class MsgReceiver {

    /**
     * 通过 @RabbitListener 注解指定该方法监听的消息队列，该注解的参数就是消息队列的名字
     */
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void handleMsg(String msg) {
        System.out.println("msg = " + msg);
    }
}
