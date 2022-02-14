package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMovable_자동차_전진_가능(int argument) {
        Car car = new Car("testCar");
        assertThat(car.isMovable(argument)).isEqualTo(true);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isMovable_자동차_전진_불가능(int argument) {
        Car car = new Car("testCar");
        assertThat(car.isMovable(argument)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void movePosition_자동차_전진_성공(int argument) {
        //given
        Car car = new Car("testCar");

        //when
        car.movePosition(argument);

        //then
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void movePosition_자동차_전진_실패(int argument) {
        //given
        Car car = new Car("testCar");

        //when
        car.movePosition(argument);

        //then
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    void isSamePosition_같은_포지션() {
        //given
        Car car = new Car("testCar");
        car.setPosition(1);

        //when
        assertThat(car.isSamePosition(1)).isEqualTo(true);
    }

    @Test
    void isSamePosition_다른_포지션() {
        //given
        Car car = new Car("testCar");
        car.setPosition(1);

        //when
        assertThat(car.isSamePosition(2)).isEqualTo(false);
    }


}
