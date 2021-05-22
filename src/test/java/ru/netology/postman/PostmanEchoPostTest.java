package ru.netology.postman;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoPostTest {
    @Test
    void shouldPostData() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(404)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldPostMessage() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("You made a POST request with the following data!")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("You made a POST request with the following data!"))
        ;
    }
}
