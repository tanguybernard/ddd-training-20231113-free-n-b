package com.zenika.training.publication;

import com.zenika.training.publication.application.CreateWorkspace;
import com.zenika.training.publication.infrastructure.WorkspaceRepositoryImplStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateWorkspace createWorkspace() {
        return new CreateWorkspace(new WorkspaceRepositoryImplStub());
    }

}
