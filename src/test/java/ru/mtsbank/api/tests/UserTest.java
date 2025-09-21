package ru.mtsbank.api.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.api.dto.LoginResponse;

import static io.restassured.RestAssured.given;
import static ru.mtsbank.api.data.TestData.*;

public class UserTest {

    private String token;
    private String id;
    private RequestSpecification requestSpecification;
    private LoginResponse loginResponse;
    private String title;
    private String description;
    private String company;
    private String category;
    private boolean completed;

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

    @Test(dependsOnMethods = "testRegister", dataProvider = "credentials")
    public void testNegativeRegister(String name, String email, String password) {

         loginResponse = given()
                .spec(requestSpecification)
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)

                .when()
                .post("/users/register")

                .then()
                .statusCode(409)
                 .extract().as(LoginResponse.class);
         String message = loginResponse.getMessage();

         Assert.assertEquals(message, REGISTER_MESSAGE_ERROR);
    }


    @Test(dependsOnMethods = "testNegativeRegister")
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
                .statusCode(401);

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

        loginResponse = given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .formParam("title", TITLE)
                .formParam("description", DESCRIPTION)
                .formParam("category", CATEGORY)

                .when()
                .post("/notes")

                .then()
                .statusCode(200)
                .extract().as(LoginResponse.class);

        this.id = loginResponse.getData().getId();
        this.title = loginResponse.getData().getTitle();
        this.description = loginResponse.getData().getDescription();
        this.completed = loginResponse.getData().getCompleted();
        this.category = loginResponse.getData().getCategory();

        Assert.assertEquals(loginResponse.getData().getId(), this.id);
        Assert.assertEquals(loginResponse.getData().getTitle(), this.title);
        Assert.assertEquals(loginResponse.getData().getDescription(), this.description);
        Assert.assertEquals(loginResponse.getData().getCategory(), this.category);


    }

    @Test(dependsOnMethods = "testCreateNewNote")
    public void testGetAllNotes() {

        given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)

                .when()
                .get("/notes")

                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "testGetAllNotes")
    public void testPutUpdateNotes() {

        loginResponse = given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .queryParam("id", this.id)
                .formParam("title", NEW_TITLE)
                .formParam("description", NEW_DESCRIPTION)
                .formParam("completed", false)
                .formParam("category", NEW_CATEGORY)

                .when()
                .put("/notes/" + this.id)

                .then()
                .statusCode(200)
                .extract().as(LoginResponse.class);

        this.title = loginResponse.getData().getTitle();
        this.description = loginResponse.getData().getDescription();
        this.completed = loginResponse.getData().getCompleted();
        this.category = loginResponse.getData().getCategory();

        Assert.assertEquals(this.title, NEW_TITLE);
        Assert.assertEquals(this.description, NEW_DESCRIPTION);
        Assert.assertFalse(this.completed);
        Assert.assertEquals(this.category, NEW_CATEGORY);
    }

    @Test(dependsOnMethods = "testPutUpdateNotes")
    public void testGetNotes() {

        given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .formParam("id", this.id)

                .when()
                .get("/notes/" + this.id)

                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "testGetNotes")
    public void testPatchUpdateNotes() {

        loginResponse = given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .queryParam("id", this.id)
                .formParam("completed", true)

                .when()
                .patch("/notes/" + this.id)

                .then()
                .statusCode(200)
                .extract().as(LoginResponse.class);

        Assert.assertEquals(loginResponse.getMessage(), NOTE_PATCH);
        Assert.assertTrue(loginResponse.getData().getCompleted());

    }


    @AfterClass(dependsOnMethods = "testDeleteNotes")
    public void testDeleteAccount() {

       given()
                .spec(requestSpecification)
                .header("x-auth-token", this.token)

                .when()
                .delete("/users/delete-account")

                .then()
                .statusCode(200);
    }

    @AfterClass
    public void testDeleteNotes() {

        given()
                .spec(requestSpecification)
                .header(TOKEN, this.token)
                .queryParam("id", this.id)

                .when()
                .delete("/notes/" + this.id)

                .then()
                .statusCode(200);
    }



    @DataProvider(name = "credentials")
    public Object[][] creds() {
        return new Object[][] {
                {"Karim","testkarims123456789@gmail.com","12345karimS"},
        };
    }

}
