package co.com.udea.calidad.busquedaVuelosA.stepdefinitions;

import co.com.udea.calidad.busquedaVuelosA.tasks.ConnectTo;
import co.com.udea.calidad.busquedaVuelosA.tasks.CreateClient;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ClientCreationStepDefinition {

    Actor user = Actor.named("user");
    @Before
    @Given("I am connected to the system to register a new client")
    public void iAmConnectedToTheSystemToRegisterANewClient() {
        user.attemptsTo(ConnectTo.theService());
    }
    @When("I send a POST request to register myself with my info")
    public void iSendAGetRequestToRegisterMyselfWithMyInfo(){
        user.attemptsTo(CreateClient.service());
    }
    @Then("the response should have a status code of 201")
    public void theResponseShouldHaveAStatusCodeOf201(){
        user.should(
                seeThatResponse("El cliente fue creado exitosamente",response->response.statusCode(201)));
    }

    @And("I send a GET request to get the client ID")
    public void iSendAGETRequestToGetTheClientID() {
    }
}
