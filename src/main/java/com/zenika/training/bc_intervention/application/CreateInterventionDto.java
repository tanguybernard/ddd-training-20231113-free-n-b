package com.zenika.training.bc_intervention.application;

public class CreateInterventionDto {


    public String technicienId;
    public String clientId;
    public String clientName;
    public String clientAddressName;
    public String clientAddressPostalCode;

    public CreateInterventionDto(
        String technicienId,
        String ClientId, 
        String ClientName, 
        String ClientAddressName,
        String ClientAddressPostalCode
        ){
            this.technicienId = technicienId;
            clientId = ClientId;
            clientName = ClientName;
            clientAddressName = ClientAddressName;
            clientAddressPostalCode = ClientAddressPostalCode;

    }

    
}
