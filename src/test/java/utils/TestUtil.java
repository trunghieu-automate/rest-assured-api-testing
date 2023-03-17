package utils;

import groovyjarjarasm.asm.TypeReference;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

public class TestUtil {
    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }
}
