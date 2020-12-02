package com.behsa.usdp.serviceeventdelivery.domain;

import com.behsa.usdp.serviceeventdelivery.enums.EventActionStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
//@Table(name = "VW_RABBIT_EVENT_ACTION", schema = "USSD_MIGRATE_CRM", catalog = "")
@RequiredArgsConstructor
@Data
public class EventAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_RABBIT_EVENT_ACTION")
    private long id;
    private EventActionStatus status;
    private LocalDateTime serviceReceiveDate;
    private LocalDateTime serviceFinishDate;
    private LocalDateTime deliverDate;


}
