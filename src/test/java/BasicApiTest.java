import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_GetStatusCodeThenPrintResponseObject() {
        res = utils.RestAssuredUtil.getResponse(Endpoints.EP_POST);
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Clients: " + jp.prettify());
    }

    @Test
    public void T02_GetRandomRequestThenPrintSomeProperties() {
        res = utils.RestAssuredUtil.getResponse(Endpoints.EP_POST + "/36");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        assertEquals(jp.get("title"), "fuga nam accusamus voluptas reiciendis itaque");
    }

    @Test
    public void T03_SchemeValidation(){
        res = utils.RestAssuredUtil.getResponse(Endpoints.EP_POST + "/10");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Object: " + testUtil.getClients(jp));
        // TODO : scheme validation testing
    }

    @Test
    public void T04_PostRequestThanPrintResposeTest(){
        String body = "{ \n" +
        "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": \"1\" \n}";
        res = utils.RestAssuredUtil.postResponse(body, Endpoints.EP_POST);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Pretty print: \n" + jp.prettify());
    }

    @Test
    public void T5_PutRequestThenPrintResponse(){
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"baz\",\n" +
                "  \"userId\": \"1\",\n" +
                "  \"id\": \"1\" \n}";
        res = utils.RestAssuredUtil.putResponse(requestBody, Endpoints.EP_POST + "/1");
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Pretty print: \n" + jp.prettify());
    }
}
