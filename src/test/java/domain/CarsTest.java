package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(List.of(
                new Car("carA"),
                new Car("carB"),
                new Car("carC")
        ));
    }

    @Test
    void findByNameTest1() {
        //given

        //when
        String carName = "carA";
        Car findedCar = cars.findByName(carName);

        //then
        assertThat(findedCar.getName()).isEqualTo(carName);
    }

    @Test
    void findByNameTest2() {
        //given

        //when
        String carName = "carD";

        //then
        assertThatThrownBy(() -> cars.findByName(carName))
                .isInstanceOf(RuntimeException.class);
    }
}