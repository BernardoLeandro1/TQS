package lab6;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;


    @BeforeEach
    void setup() {
        mockMvc(mvc);
    }


    @Test
    void whenPostCar_thenCreateCar() throws Exception {
        Car renault = new Car("Porsche", "Caen");

        when(service.save(Mockito.any())).thenReturn(renault);
        
        given()
            .contentType("application/json")
            .body(renault)
        .when()
            .post("/api/cars")
        .then()
            .status(HttpStatus.CREATED)
            .body("maker", equalTo("Porsche"))
            .body("model", equalTo("Caen"));

        verify(service).save(Mockito.any());
    }

    @Test
    void givenCars_whenGetCars_thenReturnJsonArray() throws Exception {
        Car renault = new Car("Porsche", "Caen");
        Car seat = new Car("Ford", "Focus");
        Car toyota = new Car("BMW", "i8");
        List<Car> cars = Arrays.asList(renault, seat, toyota);

        when(service.getAllCars()).thenReturn(cars);

        given()
        .when()
            .get("/api/cars")
        .then()
            .status(HttpStatus.OK)
            .body("", hasSize(3))
            .body("[0].maker", equalTo("Porsche"))
            .body("[0].model", equalTo("Caen"))
            .body("[1].maker", equalTo("Ford"))
            .body("[1].model", equalTo("Focus"))
            .body("[2].maker", equalTo("BMW"))
            .body("[2].model", equalTo("i8"));

        verify(service).getAllCars();
    }

    @Test
    void givenCars_whenGetCar_thenReturnJson() throws Exception {
        Car seat = new Car("Ford", "Focus");
        seat.setCarId(222L);

        when(service.getCarDetails(seat.getCarId())).thenReturn( Optional.of(seat) );

        given()
        .when()
            .get("/api/cars/{carId}", seat.getCarId())
        .then()
            .status(HttpStatus.OK)
            .body("maker", equalTo("Ford"))
            .body("model", equalTo("Focus"));

        verify(service).getCarDetails(seat.getCarId());
    }

    @Test
    void whenGetInvalidCar_thenReturn404() throws Exception {
        when(service.getCarDetails(Mockito.anyLong())).thenReturn(Optional.empty());

        given()
        .when()
            .get("/api/cars/-999")
        .then()
            .status(HttpStatus.NOT_FOUND);

        verify(service).getCarDetails(Mockito.anyLong());
    }

}