package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;
import com.zenika.training.shared.AggregateRoot;

public class Intervention extends AggregateRoot<InterventionId>{

    public Client client;
    public TechnicienId technicienId;



    public Intervention(InterventionId id) {
        super(id);
    }



    public Intervention(InterventionId id, Client client , TechnicienId TechnicienId) {
        super(id);
        this.client = client;
        technicienId = TechnicienId;
    }

    
}
