package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.bc_intervention.domain.intervention.events.PtoFilledDomainEvent;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;
import com.zenika.training.shared.AggregateRoot;
import com.zenika.training.shared.domain_event.DomainEvent;

public class Intervention extends AggregateRoot<InterventionId>{

    public Client client;
    public TechnicienId technicienId;

    public PtoNumber ptoNumber;



    public Intervention(InterventionId id) {
        super(id);
    }

    static Intervention create(InterventionId id, Client client , TechnicienId technicienId) {

        return new Intervention(id, client, technicienId);
    }

    static void load(){

        
    }



    public Intervention(InterventionId id, Client client , TechnicienId TechnicienId) {
        super(id);
        this.client = client;
        technicienId = TechnicienId;
    }



    public void fillPto(PtoNumber ptoNumber) {

        this.ptoNumber = ptoNumber;
        PtoFilledDomainEvent event = new PtoFilledDomainEvent(this.getId());

        event.setPto(ptoNumber);
        this.record(event);

    }

    
}
