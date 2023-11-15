package com.zenika.training.publication.domain.freelancehost;

import java.util.Objects;

public record Siret(String num) {
    public Siret {
        Objects.requireNonNull(num);
    }
}
