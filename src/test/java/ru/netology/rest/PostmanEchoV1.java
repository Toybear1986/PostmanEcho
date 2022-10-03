package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoV1 {

  @Test
  void shouldProperlyPostBodyText() {
    // Given - When - Then
// Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .body("Съешь ещё этих мягких французских булок, да выпей чаю.")
            .header("Content-Type","application/json; charset=utf-8")
            .when()
            .post("/post")
// Проверки
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("data", equalTo("Съешь ещё этих мягких французских булок, да выпей чаю."))
    ;
  }

  @Test
  void shouldFailPostBodyText() {
    // Given - When - Then
// Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .body("Съешь ещё этих мягких французских булок, да выпей чаю.")
            .header("Content-Type","application/json; charset=utf-8")
            .when()
            .post("/post")
// Проверки
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("data", equalTo("Съешь ещё этих мягких французских булок"))
    ;
  }
}
