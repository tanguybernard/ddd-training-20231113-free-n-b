package com.zenika.training.publication.domain.workspace;

import com.zenika.training.publication.domain.freelancehost.FreelanceHostId;
import com.zenika.training.shared.AggregateRoot;

public class Workspace extends AggregateRoot<WorkspaceId> {

    private final Capacity capacity;

    private final FreelanceHostId freelanceHostId;

    public Workspace(WorkspaceId workspaceId, Capacity capacity, FreelanceHostId freelanceHostId) {
        super(workspaceId);
        this.capacity = capacity;
        this.freelanceHostId = freelanceHostId;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public FreelanceHostId getFreelanceHostId() {
        return freelanceHostId;
    }
}
