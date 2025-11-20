package ru.mtsbank;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class GetV1CustomerLevelTest {

    V1CustomerLevelResponse v1CustomerLevelResponse;
    RequestSpecification requestSpecification;
    String body = "{\"rboId\":\"1423018384\"}";
    Helpers helpers = new Helpers();

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://services-ump2-test.mbrd.ru:8090/premium-clients-ref/")
                .setAccept("*/*")
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @Test(dataProvider = "getFile")
    public void testGetV1Customer(String path) throws IOException {
        v1CustomerLevelResponse = given()
               .spec(requestSpecification)
               .body(helpers.fromFileToObjectToPrettyString(path))

               .when()
               .post("/v1/customer/level")

               .then()
               .statusCode(200)
               .extract().as(V1CustomerLevelResponse.class);

       String rboId = v1CustomerLevelResponse.getRboId();

        Assert.assertEquals(rboId, "1423018384");
    }


    @DataProvider(name = "getFile")
    public Object[][] getFile() {
        return new Object[][] {
                {"src/test/java/ru/mtsbank/jsons/test.test.json"}
        };
    }
}