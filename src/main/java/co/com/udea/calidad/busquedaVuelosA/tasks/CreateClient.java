package co.com.udea.calidad.busquedaVuelosA.tasks;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class CreateClient implements Task {
    private static final String CLIENTS_ENDPOINT = "/clients";
    private String clientId;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Object> clientData = new HashMap<>();
        clientData.put("name", "Robinson");
        clientData.put("lastName", "Coronado");
        clientData.put("email", "robinson.coronado@udea.edu.co");
        clientData.put("phone", "1234567890");
        actor.attemptsTo(
                Post.to(CLIENTS_ENDPOINT).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .contentType("application/json")
                                .body(clientData)
                )
        );
    }
    public static CreateClient service(){
        return Tasks.instrumented(CreateClient.class);
    }
}
