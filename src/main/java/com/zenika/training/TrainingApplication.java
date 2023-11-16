package com.zenika.training;

import com.zenika.training.publication.application.PublishedOfferHandler;
import com.zenika.training.publication.domain.offer.PublishEvent;
import com.zenika.training.shared.domain_event.DomainEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(TrainingApplication.class, args);


        DomainEventPublisher.register(new PublishedOfferHandler(), PublishEvent.class.getName());

    }


}
