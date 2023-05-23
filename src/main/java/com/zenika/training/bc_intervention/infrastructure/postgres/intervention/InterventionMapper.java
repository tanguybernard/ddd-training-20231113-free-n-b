package com.zenika.training.bc_intervention.infrastructure.postgres.intervention;

import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Address;
import com.zenika.training.bc_intervention.domain.intervention.models.Client;
import com.zenika.training.bc_intervention.domain.intervention.models.ClientId;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;
import com.zenika.training.bc_intervention.domain.intervention.models.PostalCode;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;

public class InterventionMapper {


    public InterventionEntity fromDomain(Intervention intervention){

        InterventionEntity e =  new InterventionEntity();

        e.id = intervention.getId().id;
        e.clientId = intervention.client.getId().id;
        e.technicienId = intervention.technicienId.id;


        return e;


    }


    public Intervention toDomain(InterventionEntity e) throws PostalCodeException {

        return new Intervention(
            new InterventionId(e.id), 
            Client.create(new ClientId(e.clientId), new Address("null", new PostalCode("35000"))),
            new TechnicienId(e.technicienId)
            
            );

    }
    
}
