package com.zenika.training.bc_intervention.domain.intervention;

import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;

public interface InterventionRepository {


    public void saveIntervention(Intervention intervention);


    public Intervention getInterventionBy(InterventionId id) throws PostalCodeException;
    
}
