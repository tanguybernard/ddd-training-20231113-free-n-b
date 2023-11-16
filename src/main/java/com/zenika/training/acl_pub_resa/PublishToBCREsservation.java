package com.zenika.training.acl_pub_resa;

import com.zenika.training.reservation.api.facade.OffreDispo;

public class PublishToBCREsservation {


    void publish() {
        new OffreDispo().transmetteOffrePublie();
    }
}
