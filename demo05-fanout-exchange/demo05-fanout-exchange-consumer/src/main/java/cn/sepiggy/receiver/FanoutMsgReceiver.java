package cn.sepiggy.receiver;

import cn.sepiggy.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutMsgReceiver {

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_NAME1)
    public void handleMsg1(String msg) {
        System.out.println("FanoutMsgReceiver1 = " + msg);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_NAME2)
    public void handleMsg2(String msg) {
        System.out.println("FanoutMsgReceiver2 = " + msg);
    }
}
