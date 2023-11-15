package com.zenika.training.publication.application;

import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.publication.domain.workspace.WorkspaceId;
import com.zenika.training.publication.domain.workspace.WorkspaceRepository;

public class CreateWorkspace {

    private WorkspaceRepository workspaceRepository;

    public CreateWorkspace(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public WorkspaceId execute(Workspace cw) {
        // Save everything and all ...
        return workspaceRepository.createWorspace(cw);
    }


}
