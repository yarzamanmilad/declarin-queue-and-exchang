package com.behsa.usdp.serviceeventdelivery.consumer;

import com.behsa.usdp.serviceeventdelivery.domain.ServiceEvent;
import com.behsa.usdp.serviceeventdelivery.service.ServiceEventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ServiceEventConsumer {
    private final ServiceEventService serviceEventService;
    private final ObjectMapper mapper;
    @RabbitListener(queues = "employee-q")
    public void listen(String msg){
        System.out.println(msg);
    /*    try {
            ServiceEvent serviceEvent = mapper.readValue(msg, ServiceEvent.class);
            serviceEventService.check(serviceEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
