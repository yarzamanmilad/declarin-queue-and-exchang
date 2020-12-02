package com.behsa.usdp.serviceeventdelivery;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class ServiceEventDeliveryApplication {

    public static void main(String[] args) {
        log.error("start");
        SpringApplication.run(ServiceEventDeliveryApplication.class, args);
    }

}
