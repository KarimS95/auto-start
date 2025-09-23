package ru.mtsbank.premiumServices.premium_clients_ref.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.mtsbank.premiumServices.premium_clients_ref.dto.Response;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static ru.mtsbank.premiumServices.data.BaseData.*;
import static ru.mtsbank.premiumServices.premium_clients_ref.data.TestData.*;

public class PremiumClientsRefTest {

    private Response response;
    private RequestSpecification requestSpecification;

    InputStream v1CustomerLevelRQ = new FileInputStream("src/test/java/ru/mtsbank/premiumServices/premium_clients_ref/data/json/requests/v1.customer.level.json");

    public PremiumClientsRefTest() throws IOException {
    }


    @BeforeClass
    public void initSpec() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(HOST_NAME_TEST)
                .setContentType(CONTENT_TYPE)
                .setAccept(ACCEPT)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @Test(groups = "parallel")
    public void testV1CustomerLevel() {

        given()
                .spec(requestSpecification)
                .body(v1CustomerLevelRQ)

                .when()
                .post(REF_URI + REF_V1_CUSTOMER_LEVEL)

                .then()
                .statusCode(200)
                .body("rboId", Matchers.equalTo(RBO_ID_PREMIUM))
                .body("level", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("openDate", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("commissionDate", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("levelReason", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("levelScheme", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ));
    }

    @Test(groups = "parallel")
    public void testV1Customer() {

        given()
                .spec(requestSpecification)

                .when()
                .get(REF_URI + REF_V1_CUSTOMER + RBO_ID_PREMIUM)

                .then()
                .statusCode(200)
                .body("rboId", Matchers.equalTo(Long.parseLong(RBO_ID_PREMIUM)))
                .body("domainId", Matchers.equalTo(Integer.parseInt(DOMAIN_ID_PREMIUM)))
                .body("openDate", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("commissionDate", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("welcomeDuration", Matchers.not(empty()))
                .body("packageId", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("levelScheme", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("manager", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("vipServiceType", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ))
                .body("cosCode", allOf(
                        Matchers.not(nullValue()),
                        Matchers.not(emptyOrNullString())
                ));
    }



}
