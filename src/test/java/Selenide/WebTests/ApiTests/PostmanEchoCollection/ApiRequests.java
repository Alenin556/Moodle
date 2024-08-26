package Selenide.WebTests.ApiTests.PostmanEchoCollection;

import io.restassured.response.Response;

import java.util.Map;

import static Selenide.WebTests.ApiTests.PostmanEchoCollection.Specifications.*;
import static io.restassured.RestAssured.given;

public class ApiRequests {

    public static Response getRequest(String endpoint) {

        Response getResponse = (Response) given()
                .when()
                .get(getEP)
                .then()
                .log()
                .all()
                .extract()
                .body();

        return getResponse;
    }



    public static Response postRequest(Object body) {
        Response postResponse = (Response) given()
                .body(body)
                .when()
                .post(postEP)
                .then()
                .log()
                .all()
                .extract()
                .body();

        return postResponse;
    }

    public static Response putRequest(Object body) {
        Response putResponse = (Response) given()
                .body(body)
                .when()
                .put(putEP)
                .then()
                .log()
                .all()
                .extract()
                .body();

        return putResponse;
    }

    public static Response patchRequest(Object body) {
        Response patchResponse = (Response) given()
                .body(body)
                .when()
                .patch(patchEP)
                .then()
                .log()
                .all()
                .extract()
                .body();

        return patchResponse;
    }

    public static Response deleteRequest(Object body) {
        Response deleteResponse = (Response) given()
                .body(body)
                .when()
                .delete(deleteEP)
                .then()
                .log()
                .all()
                .extract()
                .body();

        return deleteResponse;
    }

}
