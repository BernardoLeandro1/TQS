package lab7;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    @Test
    void whenGetTodo_thenStatus200 () {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then()
            .assertThat()
            .statusCode(is(200));
    }

    @Test
    void whenGetTodo4_thenReturnEtPorroTempora() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos/4")
        .then()
            .assertThat()
            .body("title", equalTo("et porro tempora"));
    }

    @Test
    void whenGetTodos_then198And199Present() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then()
            .assertThat()
            .body("id", hasItems(198, 199));
    }

}