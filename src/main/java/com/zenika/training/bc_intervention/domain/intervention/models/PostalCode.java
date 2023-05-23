package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;

public class PostalCode {

    public String code;

    public PostalCode(String code) throws PostalCodeException{
        if(code.length() != 5){
            throw new PostalCodeException();
        }

        this.code = code;
    }

}
