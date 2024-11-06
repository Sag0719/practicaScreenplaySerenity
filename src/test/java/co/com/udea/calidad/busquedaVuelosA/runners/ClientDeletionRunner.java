package co.com.udea.calidad.busquedaVuelosA.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/delete_client_info.feature",
        glue = "co.com.udea.calidad.busquedaVuelosA.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ClientDeletionRunner {}
