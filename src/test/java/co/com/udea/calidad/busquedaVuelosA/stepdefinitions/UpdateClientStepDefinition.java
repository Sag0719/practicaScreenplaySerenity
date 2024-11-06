package co.com.udea.calidad.busquedaVuelosA.stepdefinitions;

import co.com.udea.calidad.busquedaVuelosA.tasks.ConnectTo;
import co.com.udea.calidad.busquedaVuelosA.tasks.UpdateClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateClientStepDefinition {

    Actor user = Actor.named("user");
    @Given("that client with ID 1 has been registered in the system")
    public void thatAClientWithID1HasBeenRegisteredInTheSystem() {
        user.attemptsTo(ConnectTo.theService());
    }

    @When("I update the client's information with valid data")
    public void iUpdateTheClientsInformationWithValidData() {
        Map<String, Object> updatedData = new HashMap<>();
        updatedData.put("name", "Santiago");
        updatedData.put("lastName", "Arenas");
        updatedData.put("email", "santiago.arenas1@udea.edu.co");
        updatedData.put("phone", "0987654321");

        user.attemptsTo(UpdateClient.service(updatedData));
    }

    @Then("response should have a status code of 200")
    public void theResponseShouldHaveAStatusCodeOf200() {
        user.should(
                seeThatResponse("The client information was updated successfully",
                        response -> response.statusCode(200)
                )
        );
    }
}
