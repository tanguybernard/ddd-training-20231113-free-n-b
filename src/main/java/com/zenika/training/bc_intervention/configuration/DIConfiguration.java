package com.zenika.training.bc_intervention.configuration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.zenika.training.bc_intervention.application.handler.UpdateStatusPtoHandler;
import com.zenika.training.bc_intervention.application.services.FillPtoNumber;
import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.events.PtoFilledDomainEvent;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.InterventionDao;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.InterventionMapper;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.PgInterventionRepository;
import com.zenika.training.shared.domain_event.DomainEventPublisher;

@Configuration
public class DIConfiguration {


    @Bean
    public FillPtoNumber fillPtoNumber(InterventionRepository interventionRepository){

        return new FillPtoNumber(interventionRepository);

    }


    @Bean
    public InterventionRepository interventionRepository(InterventionDao dao) {
        return new PgInterventionRepository(dao, new InterventionMapper());
    }

}