package com.zenika.training.unit;

import com.zenika.training.publication.application.CreateWorkspace;
import com.zenika.training.publication.domain.freelancehost.FreelanceHostId;
import com.zenika.training.publication.domain.workspace.Capacity;
import com.zenika.training.publication.domain.workspace.Workspace;
import com.zenika.training.publication.domain.workspace.WorkspaceId;
import com.zenika.training.publication.domain.workspace.WorkspaceRepository;
import com.zenika.training.publication.infrastructure.WorkspaceRepositoryImplStub;
import org.junit.Assert;
import org.junit.Test;

public class CreateWorkspaceTest {

    @Test
    public void executeTest() {
        // Given Freelance Host
        WorkspaceRepository wr = new WorkspaceRepositoryImplStub();
        CreateWorkspace cw = new CreateWorkspace(wr);
        Capacity cap = new Capacity(3);

        FreelanceHostId fhi = new FreelanceHostId("f1");
        Workspace mw = new Workspace(new WorkspaceId("w1"), cap, fhi);

        // When Freelance Host creates workspace
        WorkspaceId wid = cw.execute(mw);
        Workspace w = wr.getWorkspace(wid);

        // Then workspace is created
        Assert.assertEquals(w.getCapacity(), cap);
        Assert.assertNotEquals(w.getCapacity(), new Capacity(4));
        Assert.assertEquals(w.getFreelanceHostId(), fhi);

    }

}
