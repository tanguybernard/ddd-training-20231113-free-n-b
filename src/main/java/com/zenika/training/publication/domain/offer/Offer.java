package com.zenika.training.publication.domain.offer;

import com.zenika.training.shared.AggregateRoot;
import com.zenika.training.shared.domain_event.DomainEvent;

public class Offer extends AggregateRoot<OfferId> {
    public Offer(OfferId offerId) {
        super(offerId);

        this.record(new PublishEvent());

    }
}
