package com.behsa.usdp.serviceeventdelivery.repository;

import com.behsa.usdp.serviceeventdelivery.domain.ServiceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceEventRepository extends JpaRepository<ServiceEvent,Long> {
    Optional<ServiceEvent> findById(Long id);
}
