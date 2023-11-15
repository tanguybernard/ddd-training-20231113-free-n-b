package com.zenika.training.publication.domain.workspace;

import com.zenika.training.shared.ValueObjectId;

public class WorkspaceId extends ValueObjectId<String> {
    public WorkspaceId(String id) {
        super(id);
    }
}
