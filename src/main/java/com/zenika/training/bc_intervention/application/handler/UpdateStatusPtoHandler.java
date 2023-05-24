package com.zenika.training.bc_intervention.application.handler;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.events.PtoFilledDomainEvent;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.shared.domain_event.EventHandler;

public class UpdateStatusPtoHandler implements EventHandler<PtoFilledDomainEvent> {


    private InterventionRepository interventionRepository;


    public UpdateStatusPtoHandler(InterventionRepository interventionRepository){
        this.interventionRepository = interventionRepository;

    }


    @Override
    public void handle(PtoFilledDomainEvent evt) throws Exception {


        Intervention intervention = this.interventionRepository.getInterventionBy(evt.id);

        //intervention.status()

        //intervetionRepository.save(event)

        
        
    }

}
