package com.zenika.training.publication.api;

import com.zenika.training.publication.application.CreateWorkspace;
import com.zenika.training.publication.domain.freelancehost.FreelanceHostId;
import com.zenika.training.publication.domain.workspace.Capacity;
import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.publication.domain.workspace.WorkspaceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
public class WorkspaceController {

    @Autowired
    private CreateWorkspace createWorkspace;

    @PostMapping("/v1/workspaces")
    public ResponseEntity<String> createWorkspace(@RequestBody WorkspaceRequest wr) {

        Workspace w = new Workspace(new WorkspaceId("w" + UUID.randomUUID()),
                new Capacity(wr.capacity()),
                new FreelanceHostId(wr.freelanceHostId()));

        createWorkspace.execute(w);
        return ResponseEntity.created(URI.create("/v1/workspaces/" + w.getId().id)).build();
    }

}
