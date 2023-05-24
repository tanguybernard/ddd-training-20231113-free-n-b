package com.zenika.training.bc_intervention.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.training.bc_intervention.application.services.FillPtoNumber;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;

@RestController
@RequestMapping("/intervention")
public class InterventionController {


    private FillPtoNumber fillPtoNumber;


    public InterventionController(FillPtoNumber fillPtoNumber) {
        this.fillPtoNumber = fillPtoNumber;

    }


    @PostMapping("/{idIntervention}/pto")
    public ResponseEntity<Object> fillPto(@PathVariable String idIntervention, @RequestBody InterventionDto dto){


            try {
                this.fillPtoNumber.execute(idIntervention, dto.pto());
                return ResponseEntity.status(HttpStatus.OK).build();
            } catch (PostalCodeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            }


    }


}
