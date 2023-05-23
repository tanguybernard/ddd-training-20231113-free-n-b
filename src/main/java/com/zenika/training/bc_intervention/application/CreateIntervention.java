package com.zenika.training.bc_intervention.application;

import java.util.UUID;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Address;
import com.zenika.training.bc_intervention.domain.intervention.models.Client;
import com.zenika.training.bc_intervention.domain.intervention.models.ClientId;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.InterventionId;
import com.zenika.training.bc_intervention.domain.intervention.models.PostalCode;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;

public class CreateIntervention {

    public InterventionRepository interventionRepository;

    public CreateIntervention(InterventionRepository interventionRepository){
        this.interventionRepository = interventionRepository;

    }

    public Intervention execute(CreateInterventionDto dto) throws PostalCodeException {

        Client client = Client.create(
            new ClientId(dto.clientId), 
            new Address(dto.clientAddressName, new PostalCode(dto.clientAddressPostalCode)));


        TechnicienId technicienId = new TechnicienId(dto.technicienId);





        Intervention intervention = new Intervention(new InterventionId(UUID.randomUUID().toString()), client, technicienId);
        
        this.interventionRepository.saveIntervention(intervention);
        
        return intervention;


    }
    
}
