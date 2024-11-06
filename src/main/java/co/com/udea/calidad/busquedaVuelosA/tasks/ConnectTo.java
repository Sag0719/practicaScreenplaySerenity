package co.com.udea.calidad.busquedaVuelosA.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ConnectTo implements Task {

    private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String url_string;

    public ConnectTo(){
        url_string = environmentVariables.getProperty("webdriver.base.url");
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.whoCan(CallAnApi.at(url_string));
        //actor.whoCan(Click.on("")); for FRONT
    }

    public static ConnectTo theService(){
        return Tasks.instrumented(ConnectTo.class);
    }
}