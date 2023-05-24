package com.zenika.training.bdd.stepdefs;

import com.zenika.training.bc_intervention.domain.intervention.InterventionRepository;
import com.zenika.training.bc_intervention.domain.intervention.exceptions.PostalCodeException;
import com.zenika.training.bc_intervention.domain.intervention.models.*;
import com.zenika.training.bc_intervention.domain.technicien.models.TechnicienId;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FillInterventionSteps {


    private Response response;



    @Before
    public void setUp() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8080";

    }



    @Autowired
    InterventionRepository interventionRepository;

    @Given("I have intervention {string}")
    public void iHaveIntervention(String interventionId) throws PostalCodeException {


        Intervention intervention = new Intervention(
                new InterventionId(interventionId),
                Client.create(new ClientId("toto"), new Address("Paris", new PostalCode("55555"))),
                new TechnicienId("idTech")

        );

        interventionRepository.saveIntervention(intervention);



    }

    @When("Technicien fill PTO number {string} for intervention {string}")
    public void technicienFillPTONumber(String ptoNumber, String interventionId) {

        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("pto", ptoNumber);

        httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        response = httpRequest.post("/intervention/"+interventionId+"/pto");

    }



    @Then("the reponse will return status {int}")
    public void theReponseWillReturnStatus(int status) {

        int statusCode = response.getStatusCode();

        assertThat(statusCode).isEqualTo(status);


    }



}
