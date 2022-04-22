package lab6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


class DtoTest {

    @Autowired
    private CarDTO car = new CarDTO(224L, "Porsche", "Panamera");

    @Test
    void testCreated(){
        assertThat(car.getMaker()).isEqualTo("Porsche");
        assertThat(car.getModel()).isEqualTo("Panamera");
        assertThat(car.getId()).isEqualTo(224L);
    }

    @Test
    void modifyAndTest(){
        car.setId(222L);
        car.setMaker("Ferrari");
        car.setModel("F40");
        assertThat(car.getMaker()).isEqualTo("Ferrari");
        assertThat(car.getModel()).isEqualTo("F40");
        assertThat(car.getId()).isEqualTo(222L);
    }

}
