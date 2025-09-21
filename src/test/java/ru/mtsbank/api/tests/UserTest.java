package ru.mtsbank.api.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.mtsbank.api.dto.LoginResponse;

import static io.restassured.RestAssured.given;
import static ru.mtsbank.api.data.TestData.*;

public class UserTest {

    private String token;
    private String id;
    private RequestSpecification requestSpecification;
    private LoginResponse loginResponse;

    @BeforeClass
    public void initSpec() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(CONTENT_TYPE)
                .setAccept(ACCEPT)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @Test
    public void testRegister() {

        loginResponse = given()
                .spec(requestSpecification)
                .formParam("name", NAME)
                .formParam("email", EMAIL)
                .formParam("password", PASSWORD)

                .when()
                .post("/users/register")

                .then()
                .statusCode(201)
                .extract().as(LoginResponse.class);
        String message = loginResponse.getMessage();

        Assert.assertEquals(message, REGISTER_MESSAGE);
    }


    @Test(dependsOnMethods = "testRegister")
    public void testLogin() {
         loginResponse = given()
                .spec(requestSpecification)
                .formParam("email", EMAIL)
                .formParam("password", PASSWORD)

                .when()
                .post("/users/login")

                .then()
                .statusCode(200)
                .extract().as(LoginResponse.class);
        this.token = loginResponse.getData().getToken();

        Assert.assertEquals(loginResponse.getMessage(), LOGIN_SUCCESSFUL);
    }

    @Test(dependsOnMethods = "testLogin")
    public void testGetProfile() {

        given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)

                .when()
                .get("/users/profile")

                .then()
                .statusCode(200);

    }

    @Test(dependsOnMethods = "testGetProfile")
    public void testPathProfile() {
       loginResponse = given()
                .spec(requestSpecification)
                .formParam("name", NEW_NAME)
                .header(TOKEN, this.token)

                .when()
                .patch("/users/profile")

                .then()
                .statusCode(200)
                .extract().as(LoginResponse.class);


        Assert.assertEquals(loginResponse.getMessage(), PATH_PROFILE_MESSAGE);
    }

    @Test(dependsOnMethods = "testPathProfile")
    public void testForgotPassword() {

        given()
                .spec(requestSpecification)
                .formParam("email", EMAIL_FORGOT_PASSWORD)

                .when()
                .post("/users/forgot-password")

                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "testForgotPassword")
    public void testRestPassword() {

        given()
                .spec(requestSpecification)
                .formParam("token", this.token)
                .formParam("newPassword", NEW_PASSWORD)

                .when()
                .post("/users/reset-password")

                .then()
                .statusCode(200);

    }

    @Test(dependsOnMethods = "testForgotPassword")
    public void testChangePassword() {

        given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .formParam("currentPassword", PASSWORD)
                .formParam("newPassword", NEW_PASSWORD)

                .when()
                .post("/users/change-password")

                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "testChangePassword")
    public void testCreateNewNote() {

         given()
                .spec(requestSpecification)
                .formParam("title", TITLE)
                .formParam("description", DESCRIPTION)
                .formParam("category", CATEGORY)

                .when()
                .param("/notes")

                .then()
                .statusCode(200);
    }


    @AfterClass
    public void testDeleteAccount() {

       loginResponse = given()
                .spec(requestSpecification)
                .header("x-auth-token", this.token)

                .when()
                .delete("/users/delete-account")

                .then()
                .statusCode(200)
               .extract().as(LoginResponse.class);
       this.id = loginResponse.getData().getId();
    }

    @AfterClass
    public void testDeleteNotes() {

        given()
                .spec(requestSpecification)
                .formParam("id", this.id)

                .when()
                .delete("/notes/")

                .then()
                .statusCode(200);
    }


}
