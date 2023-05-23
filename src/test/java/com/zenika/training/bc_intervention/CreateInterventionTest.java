package com.zenika.training.bc_intervention;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.zenika.training.bc_intervention.domain.intervention.models.Address;
import com.zenika.training.bc_intervention.domain.intervention.models.Client;
import com.zenika.training.bc_intervention.domain.intervention.models.ClientId;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.PostalCode;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;

import groovy.cli.CliBuilderException;

public class CreateInterventionTest {


    @Test
    void createIntervention(){
       //GIVEN

       ClientId clientId = new ClientId("abc");

       Address address = new Address("paris", new PostalCode("75000"));

       Client client = Client.create(clientId, address);
       
       TechnicienId techId = new TechnicienId("techId");

       
       //WHEN

       CreateIntervention useCase = new CreateIntervention();

       Intervention intervention = useCase.execute();

    
       //THEN


       assertEquals(intervention.client.getId(), client.getId());


    }
    
}
