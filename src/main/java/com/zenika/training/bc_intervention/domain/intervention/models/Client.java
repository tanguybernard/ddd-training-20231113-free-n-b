package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.shared.Entity;

public class Client extends Entity<ClientId>{


    private Client(ClientId id, Address address){

    }

    public static Client create(ClientId id, Address address){

        return new Client(id, address);

    }

}
