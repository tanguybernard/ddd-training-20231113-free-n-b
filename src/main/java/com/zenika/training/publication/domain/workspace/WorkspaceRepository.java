package com.zenika.training.publication.domain.workspace;

public interface WorkspaceRepository {

    WorkspaceId createWorspace(Workspace w);

    Workspace getWorkspace(WorkspaceId id);

}
