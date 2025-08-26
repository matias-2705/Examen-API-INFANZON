package com.nttdata.glue;

import com.nttdata.steps.StoreStepsMIC;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepMIC

{

    @Steps
    StoreStepsMIC store;

    @Given("defino la URL {string}")
    public void definoLaURL(String url) {
        store.setURL_BASE(url);
    }

    @When("creo una orden con id {int} y idmascota {int}")
    public void creoUnaOrdenConIdYpetId(int id, int petId) {
        store.crearOrden(id, petId);
    }

    @When("consulto la orden de ID {int}")
    public void consultoLaOrdenDeID(int id) {
        store.consultarOrden(id);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCodeEsperado) {
        store.validarStatusCode(statusCodeEsperado);
    }

    @And("valido que el status de la orden sea {string}")
    public void validoQueElStatusDeLaOrdenSea(String statusEsperado) {
        store.validarCampoStatus(statusEsperado);
    }

    @And("valido que el campo id sea {int}")
    public void validoQueElCampoIdSea(int idEsperado) {
        store.validarCampoId(idEsperado);
    }




}
