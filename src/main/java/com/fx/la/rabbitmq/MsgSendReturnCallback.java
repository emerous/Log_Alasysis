package com.fx.la.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * <dl>
 * <dt>MsgSendReturnCallback</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 2017/7/4</dd>
 * </dl>
 *
 * @author rong.kuang
 */
public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String msgJson  = new String(message.getBody());
        System.out.println("回馈消息："+msgJson);
    }
}
