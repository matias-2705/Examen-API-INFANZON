package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class StoreStepsMIC {

    private String URL_BASE;
    Response response;

        public void setURL_BASE(String URL_BASE) {
            this.URL_BASE = URL_BASE;
        }

    //POST
    public void crearOrden(int id, int idmascota) {
        String body = "{"
                + "\"id\":" + id + ","
                + "\"idmascota\":" + idmascota + ","
                + "\"quantity\":1,"
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";

        response = RestAssured
                .given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(this.URL_BASE)
                .log().all()
                .body(body)
                .when()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    //GET
    public void consultarOrden(int id) {
        response = RestAssured
                .given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(this.URL_BASE)
                .log().all()
                .when()
                .get("/store/order/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    // Validaciones
    public void validarStatusCode(int statusCodeEsperado) {
        Assert.assertEquals("Status Code", statusCodeEsperado, response.statusCode());
    }

    public void validarCampoStatus(String statusEsperado) {
        Assert.assertEquals("Campo 'status'", statusEsperado, response.jsonPath().getString("status"));
    }

    public void validarCampoId(int idEsperado) {
        Assert.assertEquals("Campo 'id'", idEsperado, response.jsonPath().getInt("id"));
    }
}
