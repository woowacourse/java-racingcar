package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carA.move(4);
        carA.move(4);

        carB.move(4);
        carB.move(4);
        carB.move(4);

        carC.move(4);
        carC.move(4);
        carC.move(4);

        cars = new Cars(List.of(
                carA,
                carB,
                carC
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
