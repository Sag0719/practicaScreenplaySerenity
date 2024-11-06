package co.com.udea.calidad.busquedaVuelosA.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

public class UpdateClient implements Task {

    private static final String CLIENTS_ENDPOINT = "/clients/1";
    private final Map<String, Object> updatedClientData;

    public UpdateClient(Map<String, Object> updatedClientData) {
        this.updatedClientData = updatedClientData;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(CLIENTS_ENDPOINT).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .contentType("application/json")
                                .body(updatedClientData)
                )
        );

    }

    public static UpdateClient service(Map<String, Object> updatedData) {
        return Tasks.instrumented(UpdateClient.class, updatedData);
    }
}
