package com.zenika.training.bc_intervention.application.services;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;
import com.zenika.training.bc_intervention.domain.intervention.models.PtoNumber;
import com.zenika.training.bc_intervention.infrastructure.rabbitmq.PtoFilledIntegrationEvent;
import com.zenika.training.shared.domain_event.DomainEventPublisher;

public class FillPtoNumber {



    public InterventionRepository interventionRepository;

    public FillPtoNumber(InterventionRepository interventionRepository){  //Bus
        this.interventionRepository = interventionRepository;

    }



    public void execute(String interventionId, String ptoNumber) throws PostalCodeException{


        Intervention intervention = interventionRepository
        .getInterventionBy(new InterventionId(interventionId));



        intervention.fillPto(new PtoNumber(ptoNumber));

        interventionRepository.saveIntervention(intervention); //sauvegarde en base de données


        intervention.pullDomainEvents().forEach(DomainEventPublisher::dispatch);


        //interventionGatewayRestApi.saveIntervention(intervention) /// appel http vers service externe


        //bus.pusblish(new PtoFilledIntegrationEvent());  //publication event bus rabbitmq ou kafka



    }



    
}
