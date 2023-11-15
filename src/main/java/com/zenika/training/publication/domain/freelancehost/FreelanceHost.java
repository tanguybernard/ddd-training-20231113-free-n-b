package com.zenika.training.publication.domain.freelancehost;

import com.zenika.training.shared.AggregateRoot;

public class FreelanceHost extends AggregateRoot<FreelanceHostId> {

    private String name;

    private Siret siret;

    public FreelanceHost(FreelanceHostId freelanceHostId, String name, Siret siret) {
        super(freelanceHostId);
        this.name = name;
        this.siret = siret;
    }

    public Siret getSiret() {
        return siret;
    }

    public String getName() {
        return name;
    }
}
