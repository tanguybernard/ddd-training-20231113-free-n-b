package com.zenika.training.bc_intervention.domain.intervention.models;

import com.zenika.training.shared.ValueObjectId;

public class InterventionId extends ValueObjectId<String> {

    protected InterventionId(String id) {
        super(id);
    }

}
