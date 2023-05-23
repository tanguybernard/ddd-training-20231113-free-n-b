package com.zenika.training.bc_intervention.infrastructure.stubs;

import java.util.HashMap;
import java.util.Map;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;

public class InMemoryInterventionRepository implements InterventionRepository{

    Map<String,Intervention> listIntervention = new HashMap<>();


    @Override
    public void saveIntervention(Intervention intervention) {
        listIntervention.put(intervention.getId().id, intervention);
    }


    @Override
    public Intervention getInterventionBy(InterventionId id) {

        return listIntervention.get(id.id);
        
    }
    
}
