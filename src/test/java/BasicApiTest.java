import org.testng.annotations.Test;
import utils.Endpoints;
import utils.TestUtil;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_GetStatusCodeThenPrintResponseObject() {
        res = utils.RestAssuredUtil.getResponse(Endpoints.RANDOM);
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Clients: " + jp.prettify());
    }

    @Test
    public void T02_GetRandomRequestThenPrintSomeProperties() {
        res = utils.RestAssuredUtil.getResponse(Endpoints.RANDOM);
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Type: " + jp.get("type"));
        System.out.println("Activity: " + jp.get("activity"));
        System.out.println("Price: " + jp.get("price"));
        System.out.println("Key: " + jp.get("key"));
    }
}
