package com.behsa.usdp.serviceeventdelivery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ServiceEvent {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Boolean  status;
}
