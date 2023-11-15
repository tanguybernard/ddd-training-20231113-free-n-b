package com.zenika.training.publication.infrastructure;

import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.publication.domain.workspace.WorkspaceId;
import com.zenika.training.publication.domain.workspace.WorkspaceRepository;

import java.util.HashMap;

public class WorkspaceRepositoryImplStub implements WorkspaceRepository {

    private final HashMap<WorkspaceId, Workspace> suberDb = new HashMap<>();

    @Override
    public WorkspaceId createWorspace(Workspace w) {
        suberDb.put(w.getId(), w);
        return w.getId();
    }

    @Override
    public Workspace getWorkspace(WorkspaceId id) {
        if (suberDb.containsKey(id)) {
            return suberDb.get(id);
        }
        throw new UnsupportedOperationException("Does not exists");
    }
}
