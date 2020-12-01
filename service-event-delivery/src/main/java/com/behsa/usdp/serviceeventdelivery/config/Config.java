package com.behsa.usdp.serviceeventdelivery.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    static final String directExchangeName = "x.ServiceEventDelivery";
    static final String directQueueName = "q.ServiceEventDelivery";
    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    @Bean
    Queue queue() {
        return new Queue(directQueueName, true);
    }
    @Bean
    DirectExchange getDirectExchange(){
        return new DirectExchange(directExchangeName);
    }
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("serviceEvent");
    }
    @Bean
    MessageListenerAdapter getMessageListenerAdapter(){
        MessageListenerAdapter adapter=new MessageListenerAdapter();
        return adapter;
    }
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(directQueueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
