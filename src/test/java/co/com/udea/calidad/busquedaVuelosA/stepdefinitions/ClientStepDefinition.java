package co.com.udea.calidad.busquedaVuelosA.stepdefinitions;

import co.com.udea.calidad.busquedaVuelosA.tasks.ConnectTo;
import co.com.udea.calidad.busquedaVuelosA.tasks.ConsumThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ClientStepDefinition {

    Actor user = Actor.named("user");

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("I am connected to the system")
    public void iAmConnectedToTheSystem (){
        user.attemptsTo(ConnectTo.theService());
    }
    @And("I am a new client")
    public void iAmANewClient(){}
    @When("I send a POST request to register myself with my info")
    public void iSendAGetRequestToRegisterMyselfWithMyInfo(){
        user.attemptsTo(ConsumThe.service());
    }
    @Then("the response should have a status code of 200")
    public void theResponseShouldHaveAStatusCodeOf200(){
        //Question
        user.should(seeThatResponse(response->response.statusCode(201)
                //.body("", Matchers.equalTo("")
        ));

    }
    /*And I send a GET request to view all the clients
    When I send a PUT request to update the client with ID "1"
   public void thisIsTheMethod(){
        //all tasks
        user.attemptsTo();
    }*/

    

}
