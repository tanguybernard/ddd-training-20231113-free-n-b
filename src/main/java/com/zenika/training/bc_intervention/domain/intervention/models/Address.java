package com.zenika.training.bc_intervention.domain.intervention.models;

public class Address {


    private String name;
    private PostalCode postalCode;


    public Address(String name, PostalCode postalCode){
        this.name = name;
        this.postalCode = postalCode;

    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Address){
            Address a = (Address) obj;
            return this.name.equals(a.name) && this.postalCode.equals(a.postalCode);

        }
        return false;

    }
    
}
