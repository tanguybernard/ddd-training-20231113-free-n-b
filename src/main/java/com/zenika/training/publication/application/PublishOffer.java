package com.zenika.training.publication.application;

import com.zenika.training.publication.domain.freelancehost.FreelanceHostId;
import com.zenika.training.publication.domain.freelancehost.VerifyFreelanceHaveNotUsedWorkspaceForAnPublishedOffer;
import com.zenika.training.publication.domain.offer.Offer;
import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.shared.domain_event.DomainEventPublisher;
import com.zenika.training.shared.infrastructure.IntegrationEvent;

import javax.transaction.Transactional;

public class PublishOffer {



    void execute(Workspace workspace, FreelanceHostId freelanceHostId) {

        VerifyFreelanceHaveNotUsedWorkspaceForAnPublishedOffer domainService =
                new VerifyFreelanceHaveNotUsedWorkspaceForAnPublishedOffer(null, null)
;
        try{
            Offer offer = domainService.verify(freelanceHostId, workspace);

            //ASYNC
            offer.pullDomainEvents().stream().forEach(event -> {
                 DomainEventPublisher.dispatch(event);
            });

            // SYNC
            // useCase
            // useCase


        }
        catch(Exception e){

        }


        //Gateway.dispath(new IntegrationEvent('Publication'));





    }
}
