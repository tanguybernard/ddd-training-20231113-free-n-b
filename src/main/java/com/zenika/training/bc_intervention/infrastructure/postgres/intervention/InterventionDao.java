package com.zenika.training.bc_intervention.infrastructure.postgres.intervention;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InterventionDao extends JpaRepository<InterventionEntity, String>{
    
}
