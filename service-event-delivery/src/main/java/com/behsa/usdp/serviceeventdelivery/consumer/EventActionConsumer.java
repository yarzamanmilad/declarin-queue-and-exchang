package com.behsa.usdp.serviceeventdelivery.consumer;


import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.service.EventActionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class EventActionConsumer {

    private final ObjectMapper mapper;
    private final EventActionService eventActionService;
    @RabbitListener(queues = "eventService/deliver")
    private void listen(String  msg){
        System.out.println(msg);


       try {
            EventAction eventAction = mapper.readValue(msg, EventAction.class);
            eventActionService.update(eventAction);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
