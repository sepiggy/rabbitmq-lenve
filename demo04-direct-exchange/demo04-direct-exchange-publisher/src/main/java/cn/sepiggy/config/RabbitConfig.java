package cn.sepiggy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Direct 路由策略将消息队列绑定到 DirectExchange 上，
 * 当消息到达交换机的时候，消息会携带一个 routing_key，
 * 然后交换机会找到名为 routing_key 的队列，将消息路由过去
 */
@Configuration
public class RabbitConfig {

    // 两个队列名称
    public static final String DIRECT_QUEUE_NAME1 = "direct_queue_name";
    public static final String DIRECT_QUEUE_NAME2 = "direct_queue_name";
    // 交换机名称
    public static final String DIRECT_EXCHANGE_NAME = "direct_exchange_name";

    /**
     * 定义两个队列
     */
    @Bean
    Queue directQueue1() {
        return new Queue(DIRECT_QUEUE_NAME1, true, false, false);
    }

    @Bean
    Queue directQueue2() {
        return new Queue(DIRECT_QUEUE_NAME2, true, false, false);
    }

    /**
     * 定义一个直连交换机
     */
    @Bean
    DirectExchange directExchange() {
        // 参数说明：
        // 1. 交换机的名称
        // 2. 交换机是否持久化（RabbitMQ重启之后是否还存在）
        // 3. 如果没有与之绑定的队列，是否删除交换机
        return new DirectExchange(DIRECT_EXCHANGE_NAME, true, false);
    }

    /**
     * 定义两个绑定：将交换机和队列绑定起来
     * 交换机通过 routing_key 将队列和消息绑定起来
     */
    @Bean
    Binding directBinding1() {
        return BindingBuilder
                // 设置绑定的队列
                .bind(directQueue1()) // 使用返回值的形式进行依赖注入
                // 设置绑定的交换机
                .to(directExchange())
                // 设置 routing_key
                .with(DIRECT_QUEUE_NAME1);
    }

    @Bean
    Binding directBinding2() {
        return BindingBuilder
                .bind(directQueue2())
                .to(directExchange())
                .with(DIRECT_QUEUE_NAME2);
    }
}
