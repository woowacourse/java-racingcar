package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 30, 80, 110})
    @DisplayName("4 이상의 값을 받으면 자동차가 이동한다")
    void moveCar(int number) {
        //given
        Car car = new Car("pobi");
        //when
        car.tryMove(number);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3})
    @DisplayName("4 미만의 값을 받으면 자동차가 이동하지 않는다")
    void doNotMoveCar(int number) {
        //given
        Car car = new Car("pobi");
        //when
        car.tryMove(number);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}