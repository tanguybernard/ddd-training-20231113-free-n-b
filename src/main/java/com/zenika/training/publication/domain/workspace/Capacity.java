package com.zenika.training.publication.domain.workspace;

public record Capacity(int value){

    public Capacity {
        if (value <  0) {
            throw new RuntimeException("Erreur ....");
        }
    }
}
