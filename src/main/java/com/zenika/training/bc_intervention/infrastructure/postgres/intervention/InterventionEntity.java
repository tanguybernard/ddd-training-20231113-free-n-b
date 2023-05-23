package com.zenika.training.bc_intervention.infrastructure.postgres.intervention;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InterventionEntity {

    @Id
    public String id;


    public String clientId;


    public String technicienId;

    

    
}
