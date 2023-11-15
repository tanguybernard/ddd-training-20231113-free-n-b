package com.zenika.training.unit;

import com.zenika.training.publication.api.WorkspaceRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class CreateWorkspaceIT {


    @Test
    public void executeTest() {

        WorkspaceRequest wr = new WorkspaceRequest("f1", 10);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(wr)
                .when()
                .post("/v1/workspaces")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 201);

        // mockMvc.perform(MockMvcRequestBuilders.post("/v1/worskpace").content("{}"));


    }


}
