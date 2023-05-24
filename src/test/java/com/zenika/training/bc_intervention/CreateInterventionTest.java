package com.zenika.training.bc_intervention;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zenika.training.bc_intervention.application.CreateInterventionDto;
import com.zenika.training.bc_intervention.application.services.CreateIntervention;
import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.Address;
import com.zenika.training.bc_intervention.domain.intervention.models.Client;
import com.zenika.training.bc_intervention.domain.intervention.models.ClientId;
import com.zenika.training.bc_intervention.domain.intervention.models.Intervention;
import com.zenika.training.bc_intervention.domain.intervention.models.PostalCode;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;
import com.zenika.training.bc_intervention.infrastructure.stubs.InMemoryInterventionRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateInterventionTest {

    @Autowired
    InterventionRepository interventionRepository;

    @Test
    public void createIntervention() throws PostalCodeException{
       //GIVEN

       ClientId clientId = new ClientId("abc");

       Address address = new Address("paris", new PostalCode("75000"));

       Client client = Client.create(clientId, address);
       
       TechnicienId techId = new TechnicienId("techId");

       //InterventionRepository interventionRepository = new InMemoryInterventionRepository();



       
       //WHEN

       CreateIntervention useCase = new CreateIntervention(interventionRepository);


       CreateInterventionDto dto = new CreateInterventionDto(
        "techId", 
        "abc", 
        "toto", 
        "paris", 
        "75000");

       Intervention intervention = useCase.execute(dto);


       Intervention interventionSaved =
        interventionRepository.getInterventionBy(intervention.getId());
    
       //THEN
       assertEquals(interventionSaved.client.getId(), client.getId());


    }
    
}
