package com.zenika.training.bc_intervention.configuration;


import com.zenika.training.bc_intervention.application.handler.UpdateStatusPtoHandler;
import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.events.PtoFilledDomainEvent;
import com.zenika.training.shared.domain_event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class InitEventHandler {


    @Autowired
    InterventionRepository interventionRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initEventHandler(){

        DomainEventPublisher.register(new UpdateStatusPtoHandler(interventionRepository), PtoFilledDomainEvent.class.getName());

    }
}
