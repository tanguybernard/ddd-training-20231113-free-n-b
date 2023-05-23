package com.zenika.training.bc_intervention.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.InterventionDao;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.InterventionMapper;
import com.zenika.training.bc_intervention.infrastructure.postgres.intervention.PgInterventionRepository;

@Configuration
public class DIConfiguration {


    @Bean
    public InterventionRepository interventionRepository(InterventionDao dao) {
        return new PgInterventionRepository(dao, new InterventionMapper());
    }
}