package org.vapasi.api;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TestSwaggerCreate
{
    @Test
    public void testCreatingAUserAndValidatingStatusCode() {

        CreateUser userDetail = new CreateUser();
        userDetail.setId(0);
        userDetail.setUsername("Mano");
        userDetail.setFirstName("Mano");
        userDetail.setLastName("S");
        userDetail.setEmail("test@gmail.com");
        userDetail.setPassword("test123");
        userDetail.setPhone("6976123097");
        userDetail.setUserStatus(0);

        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(userDetail).
                        log().body().
                        when().
                        post("https://petstore.swagger.io/v2/user").
                        then().
                        assertThat().
                        statusCode(200).
                        extract().response();

        System.out.println("Response is : " + response.asPrettyString());
    }

    @Test
    public void testCreatingListOfUsersAndValidatingStatusCode() {
        ArrayList<CreateUser> userList=new ArrayList<CreateUser>();

        CreateUser userDetail = new CreateUser();
        userDetail.setId(0);
        userDetail.setUsername("seetha");
        userDetail.setFirstName("seetha");
        userDetail.setLastName("S");
        userDetail.setEmail("tests@gmail.com");
        userDetail.setPassword("test123");
        userDetail.setPhone("6976123097");
        userDetail.setUserStatus(0);
userList.add(userDetail);
userDetail.setId(0);
        userDetail.setUsername("gold");
        userDetail.setFirstName("gold");
        userDetail.setLastName("S");
        userDetail.setEmail("testd@gmail.com");
        userDetail.setPassword("test123");
        userDetail.setPhone("6976123097");
        userDetail.setUserStatus(0);
        userList.add(userDetail);

       CreatedUserResponse responseDetails =
               given().
                        contentType(ContentType.JSON).
                        body(userList).
                        log().body().
                        when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").
                        as(CreatedUserResponse.class);
        System.out.println(responseDetails);
        Assert.assertEquals(200,responseDetails.getCode());

    }
}