package com.behsa.usdp.serviceeventdelivery.service;

import com.behsa.usdp.serviceeventdelivery.domain.ServiceEvent;
import com.behsa.usdp.serviceeventdelivery.repository.ServiceEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceEventService {
    private final ServiceEventRepository  serviceEventRepository;
    public void check(ServiceEvent serviceEvent){
        ServiceEvent serviceEventTemp=find(serviceEvent);
        changeStatus(serviceEventTemp);
        saveServiceEvent(serviceEvent);
    }
    public ServiceEvent find(ServiceEvent serviceEvent){
        Optional<ServiceEvent> result = serviceEventRepository.findById(serviceEvent.getId());
        return result.orElseThrow(NullPointerException::new);


    }

    private ServiceEvent changeStatus(ServiceEvent serviceEvent) {
        serviceEvent.setStatus(!serviceEvent.getStatus());
        return saveServiceEvent(serviceEvent);
    }

    private ServiceEvent saveServiceEvent(ServiceEvent serviceEvent) {
        return serviceEventRepository.save(serviceEvent);
    }
}
