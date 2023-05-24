package com.zenika.training.bc_intervention.domain.intervention.events;

import java.time.LocalDateTime;

import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;
import com.zenika.training.bc_intervention.domain.intervention.models.PtoNumber;
import com.zenika.training.shared.ValueObjectId;
import com.zenika.training.shared.domain_event.DomainEvent;

public class PtoFilledDomainEvent implements DomainEvent {

    

    private LocalDateTime occurredOn;
    private String eventName;
    public InterventionId id;
    private PtoNumber ptoNumber;

    public  PtoFilledDomainEvent(InterventionId id){
        this.id = id;
        this.occurredOn = LocalDateTime.now();
        this.eventName = PtoFilledDomainEvent.class.getName();

    }

    public void setPto(PtoNumber ptoNumber) {
        this.ptoNumber = ptoNumber;
    }




    
}
