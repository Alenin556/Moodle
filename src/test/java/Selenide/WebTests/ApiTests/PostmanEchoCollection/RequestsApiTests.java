package Selenide.WebTests.ApiTests.PostmanEchoCollection;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static Selenide.WebTests.ApiTests.PostmanEchoCollection.ApiRequests.*;
import static Selenide.WebTests.ApiTests.PostmanEchoCollection.Specifications.*;

public class RequestsApiTests {

    @BeforeAll
    public static void setUp(){
        Specifications spec = new Specifications();
        spec.installSpecification(spec.requestSpec(URL));
    }

    @Test
    public void getEchoApiResponseTest(){
        String getEP = "get";
        Response response = getRequest(getEP);

        String responseHeadersHost = response.jsonPath().get("headers.host");
        String responseHeadersXFP = response.jsonPath().get("headers.x-forwarded-proto");
        String responseHeadersConnection = response.jsonPath().get("headers.connection");
        String responseHeadersXFPort = response.jsonPath().get("headers.x-forwarded-port");
        String responseHeadersCT = response.jsonPath().get("headers.content-type");
        String responseHeadersAccept = response.jsonPath().get("headers.accept");
        String responseHeadersUA = response.jsonPath().get("headers.user-agent");
        String responseHeadersAE = response.jsonPath().get("headers.accept-encoding");

        String responseUrl = response.jsonPath().get("url");

        Assertions.assertEquals(statusCode200,response.getStatusCode());

        Assertions.assertEquals(responseExpHeaderHost,responseHeadersHost);
        Assertions.assertEquals(responseExpXFP,responseHeadersXFP);
        Assertions.assertEquals(responseExpConnection,responseHeadersConnection);
        Assertions.assertEquals(responseExpXFPort,responseHeadersXFPort);
        Assertions.assertEquals(responseExpCT,responseHeadersCT);
        Assertions.assertEquals(responseExpAccept,responseHeadersAccept);
        Assertions.assertEquals(responseExpUA,responseHeadersUA);
        Assertions.assertEquals(responseExpAE,responseHeadersAE);

        Assertions.assertEquals(getResponseUrl,responseUrl);
    }

    @Test
    public void postEchoApiResponseTest(){

        HashMap<String,String> postBody = new HashMap<>();
        String value = "value";
        postBody.put("test",value);

        Response response = postRequest(postBody);

        String responseHeadersHost = response.jsonPath().get("headers.host");
        String responseHeadersXFP = response.jsonPath().get("headers.x-forwarded-proto");
        String responseHeadersConnection = response.jsonPath().get("headers.connection");
        String responseHeadersXFPort = response.jsonPath().get("headers.x-forwarded-port");
        String responseHeadersCT = response.jsonPath().get("headers.content-type");
        String responseHeadersAccept = response.jsonPath().get("headers.accept");
        String responseHeadersUA = response.jsonPath().get("headers.user-agent");
        String responseHeadersAE = response.jsonPath().get("headers.accept-encoding");

        String responseValue = response.jsonPath().get("json.test");
        String responseUrl = response.jsonPath().get("url");

        Assertions.assertEquals(statusCode200,response.getStatusCode());

        Assertions.assertEquals(responseExpHeaderHost,responseHeadersHost);
        Assertions.assertEquals(responseExpXFP,responseHeadersXFP);
        Assertions.assertEquals(responseExpConnection,responseHeadersConnection);
        Assertions.assertEquals(responseExpXFPort,responseHeadersXFPort);
        Assertions.assertEquals(responseExpCT,responseHeadersCT);
        Assertions.assertEquals(responseExpAccept,responseHeadersAccept);
        Assertions.assertEquals(responseExpUA,responseHeadersUA);
        Assertions.assertEquals(responseExpAE,responseHeadersAE);

        Assertions.assertEquals(value,responseValue);
        Assertions.assertEquals(postResponseUrl,responseUrl);
    }

    @Test
    public void putEchoApiResponseTest(){

        String putStringValue = "AutoTestPutEchoValue";

        Response response = putRequest(putStringValue);


        String responseHeadersHost = response.jsonPath().get("headers.host");
        String responseHeadersXFP = response.jsonPath().get("headers.x-forwarded-proto");
        String responseHeadersConnection = response.jsonPath().get("headers.connection");
        String responseHeadersXFPort = response.jsonPath().get("headers.x-forwarded-port");
        String responseHeadersCT = response.jsonPath().get("headers.content-type");
        String responseHeadersAccept = response.jsonPath().get("headers.accept");
        String responseHeadersUA = response.jsonPath().get("headers.user-agent");
        String responseHeadersAE = response.jsonPath().get("headers.accept-encoding");

        String responseValue = response.jsonPath().get("data");
        String responseUrl = response.jsonPath().get("url");

        Assertions.assertEquals(statusCode200,response.getStatusCode());

        Assertions.assertEquals(responseExpHeaderHost,responseHeadersHost);
        Assertions.assertEquals(responseExpXFP,responseHeadersXFP);
        Assertions.assertEquals(responseExpConnection,responseHeadersConnection);
        Assertions.assertEquals(responseExpXFPort,responseHeadersXFPort);
        Assertions.assertEquals(responseExpCT,responseHeadersCT);
        Assertions.assertEquals(responseExpAccept,responseHeadersAccept);
        Assertions.assertEquals(responseExpUA,responseHeadersUA);
        Assertions.assertEquals(responseExpAE,responseHeadersAE);

        Assertions.assertEquals(putStringValue,responseValue);
        Assertions.assertEquals(putResponseUrl,responseUrl);
    }

    @Test
    public void patchEchoApiResponseTest(){

        String putStringValue = "AutoTestPatchEchoValue";

        Response response = patchRequest(putStringValue);

        String responseHeadersHost = response.jsonPath().get("headers.host");
        String responseHeadersXFP = response.jsonPath().get("headers.x-forwarded-proto");
        String responseHeadersConnection = response.jsonPath().get("headers.connection");
        String responseHeadersXFPort = response.jsonPath().get("headers.x-forwarded-port");
        String responseHeadersCT = response.jsonPath().get("headers.content-type");
        String responseHeadersAccept = response.jsonPath().get("headers.accept");
        String responseHeadersUA = response.jsonPath().get("headers.user-agent");
        String responseHeadersAE = response.jsonPath().get("headers.accept-encoding");

        String responseValue = response.jsonPath().get("data");
        String responseUrl = response.jsonPath().get("url");

        Assertions.assertEquals(statusCode200,response.getStatusCode());

        Assertions.assertEquals(responseExpHeaderHost,responseHeadersHost);
        Assertions.assertEquals(responseExpXFP,responseHeadersXFP);
        Assertions.assertEquals(responseExpConnection,responseHeadersConnection);
        Assertions.assertEquals(responseExpXFPort,responseHeadersXFPort);
        Assertions.assertEquals(responseExpCT,responseHeadersCT);
        Assertions.assertEquals(responseExpAccept,responseHeadersAccept);
        Assertions.assertEquals(responseExpUA,responseHeadersUA);
        Assertions.assertEquals(responseExpAE,responseHeadersAE);

        Assertions.assertEquals(putStringValue,responseValue);
        Assertions.assertEquals(patchResponseUrl,responseUrl);
    }

    @Test
    public void deleteEchoApiResponseTest(){

        String deleteArgument = "DELETE";

        Response response = deleteRequest(deleteArgument);

        String responseHeadersHost = response.jsonPath().get("headers.host");
        String responseHeadersXFP = response.jsonPath().get("headers.x-forwarded-proto");
        String responseHeadersConnection = response.jsonPath().get("headers.connection");
        String responseHeadersXFPort = response.jsonPath().get("headers.x-forwarded-port");
        String responseHeadersCT = response.jsonPath().get("headers.content-type");
        String responseHeadersAccept = response.jsonPath().get("headers.accept");
        String responseHeadersUA = response.jsonPath().get("headers.user-agent");
        String responseHeadersAE = response.jsonPath().get("headers.accept-encoding");

        String responseValue = response.jsonPath().get("data");
        String responseUrl = response.jsonPath().get("url");

        Assertions.assertEquals(statusCode200,response.getStatusCode());

        Assertions.assertEquals(responseExpHeaderHost,responseHeadersHost);
        Assertions.assertEquals(responseExpXFP,responseHeadersXFP);
        Assertions.assertEquals(responseExpConnection,responseHeadersConnection);
        Assertions.assertEquals(responseExpXFPort,responseHeadersXFPort);
        Assertions.assertEquals(responseExpCT,responseHeadersCT);
        Assertions.assertEquals(responseExpAccept,responseHeadersAccept);
        Assertions.assertEquals(responseExpUA,responseHeadersUA);
        Assertions.assertEquals(responseExpAE,responseHeadersAE);

        Assertions.assertEquals(deleteArgument,responseValue);
        Assertions.assertEquals(deleteResponseUrl,responseUrl);
    }
}
