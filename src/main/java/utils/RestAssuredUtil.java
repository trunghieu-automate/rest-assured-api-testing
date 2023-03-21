package utils;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

import java.io.File;

public class RestAssuredUtil {
    //Sets Base URI
    public static void setBaseURI() {
        RestAssured.baseURI = PropertyUtils.get(ConfigMap.DEV);
    }

    //Sets base path
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //Returns response by given path
    public static Response getResponse(String path) {
        return given().get(path).then().extract().response();
    }

    //Returns response
    public static Response getResponse() {
        return given().get().then().extract().response();
    }
    // Post request with POJO body
    public static Response postResponse(Object body){
        return given().body(body).post().then().extract().response();
    }

    public static Response postResponse(Object body, String path){
        return given().body(body).post(path).then().extract().response();
    }

    // Put request using (full JSON payload)
    public static Response putResponse(Object body, String path){
        return given().body(body).put(path).then().extract().response();
    }
    public static Response putResponse(Object body){
        return given().body(body).put().then().extract().response();
    }

    // Patch request
    public static Response patchResponse(Object body, String path){
        return given().body(body).put(path).then().extract().response();
    }
    public static Response patchResponse(Object body){
        return given().body(body).put().then().extract().response();
    }

    // Delete request
    public static Response deleteRequest(String path){
        return given().delete().then().extract().response();
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}