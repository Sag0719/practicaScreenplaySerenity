package co.com.udea.calidad.busquedaVuelosA.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class ConsumThe implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String postEndpoint = "/clients";
        Map<String, Object> clientData = new HashMap<>();
        clientData.put("name", "John");
        clientData.put("lastName", "Doe");
        clientData.put("email", "johndoe@example.com");
        clientData.put("phone", "1234567890");

        actor.attemptsTo(
                Post.to(postEndpoint).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .contentType("application/json")
                                .body(clientData)
                )
        );
    }
    public static ConsumThe service(){
        return Tasks.instrumented(ConsumThe.class);
    }
}
