package Selenide.WebTests.ApiTests.PostmanEchoCollection;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public final static String URL = "https://postman-echo.com/";
    public final static String getResponseUrl = "http://postman-echo.com/get";;
    public final static String postResponseUrl = "http://postman-echo.com/post";;
    public final static String putResponseUrl = "http://postman-echo.com/put";
    public final static String patchResponseUrl = "http://postman-echo.com/patch";
    public final static String deleteResponseUrl = "http://postman-echo.com/delete";
    public final static String getEP = "get";
    public final static String postEP = "post";
    public final static String putEP = "put";
    public final static String patchEP = "patch";
    public final static String deleteEP = "delete";

    public final static Integer statusCode200 = 200;

    public RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public void installSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }

}
