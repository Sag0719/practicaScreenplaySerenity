package co.com.udea.calidad.busquedaVuelosA.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteClient implements Task {

    private static final String CLIENTS_ENDPOINT = "/clients";

    private final String clientId;

    public DeleteClient(String clientId) {
        this.clientId = clientId;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(CLIENTS_ENDPOINT + "/" + clientId).with(
                        request -> request
                                .relaxedHTTPSValidation()
                                .contentType("application/json")
                )
        );
    }

    public static DeleteClient service(String clientId){
        return Tasks.instrumented(DeleteClient.class, clientId);
    }
}
