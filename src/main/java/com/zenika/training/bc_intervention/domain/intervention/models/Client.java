package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.shared.Entity;

public class Client extends Entity<ClientId>{


    private Address address;

    private Client(ClientId id, Address address){
        super(id);
        this.address = address;

    }

    public static Client create(ClientId id, Address address){

        return new Client(id, address);

    }

    public ClientId getId(){

        return this.id;

    }

}
