package co.com.udea.calidad.busquedaVuelosA.stepdefinitions;

import co.com.udea.calidad.busquedaVuelosA.tasks.ConnectTo;
import co.com.udea.calidad.busquedaVuelosA.tasks.DeleteClient;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ClientDeletionStepDefinition {

    Actor user = Actor.named("user");
    @Given("I am connected to the system to delete a client")
    public void iAmConnectedToTheSystemToDeleteAClient() {
        user.attemptsTo(ConnectTo.theService());
    }

    @When("I send a DELETE request to delete my info from the system")
    public void iSendADeleteRequestToDeleteMyInfoFromTheSystem(){
        user.attemptsTo(DeleteClient.service("1"));
    }
    @Then("the response should have a status code of 200")
    public void theResponseShouldHaveAStatusCodeOf200(){
        user.should(seeThatResponse(response->response.statusCode(200)));

    }
}
