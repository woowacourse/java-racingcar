package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static CarAccelerator accelerator;

    @BeforeAll
    static void init() {
        accelerator = new CarAccelerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상 9 이하의 값을 받으면 자동차가 이동한다")
    void moveCar(int power) {
        //given
        Car car = new Car("pobi", accelerator);
        //when
        car.moveForward(power);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("4 미만의 값을 받으면 자동차가 이동하지 않는다")
//    void doNotMoveCar() {
//        //given
//        Car car = new Car("pobi");
//        //then
//        assertThat(car.getPosition()).isEqualTo(0);
//    }
}