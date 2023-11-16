package com.zenika.training.publication.domain.freelancehost;

import com.zenika.training.publication.domain.offer.Offer;
import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.publication.domain.workspace.WorkspaceRepository;

/*
Domain Service
 */
public class VerifyFreelanceHaveNotUsedWorkspaceForAnPublishedOffer {

    private final FreelanceRepository freelanceRepository;

    public VerifyFreelanceHaveNotUsedWorkspaceForAnPublishedOffer(FreelanceRepository freelanceRepository, WorkspaceRepository workspaceRepository){

        this.freelanceRepository = freelanceRepository;
    }
    public Offer verify(FreelanceHostId freeelanceHostId, Workspace workspace) {

        //List<Offer> offrePublie = OffereRepo.getBy(freeelanceHostId)

        //var result =  f.getOffer().getWorkspaces().includes(workspace);

        /*if(result) {

        var offer = new Offer(OfferId, hostId, workspace)

            offerREpo.publish(offer)

        }
        else {
            throw WorkspaceALreadyOnOffer();

        }

        */

        return null;
    }

}
