package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    Car car;
    Car compareCar;

    @BeforeEach
    void generateCar() {
        car = new Car("test", 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "6:true", "7:true"}, delimiter = ':')
    @DisplayName("자동차 전진 여부 결정 기능 테스트")
    void carCanMovingTest(int randomValue, boolean expected) {
        Assertions.assertThat(car.canMoving(randomValue)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 전진 안하는 경우 테스트")
    void carNotMoveTest() {
        int beforePosition = car.getPosition();
        car.move(false);

        Assertions.assertThat(car.getPosition()).isEqualTo(beforePosition);
    }

    @Test
    @DisplayName("자동차 전진 하는 경우 테스트")
    void carMoveTest() {
        int beforePosition = car.getPosition();
        car.move(true);

        Assertions.assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("자동차 Position 비교 테스트")
    void getLargerCarTest() {
        compareCar = new Car("compareCar", 5);

        Assertions.assertThat(car.getLargerCar(compareCar)).isEqualTo(compareCar);
    }

    @Test
    @DisplayName("Position이 같은 자동차가 있을 경우 테스트")
    void getSamePositionCarExistTest() {
        compareCar = new Car("compareCar", 0);

        Assertions.assertThat(car.getSamePositionCar(compareCar)).isEqualTo(car);
    }

    @Test
    @DisplayName("Position이 같은 자동차가 없을 경우 테스트")
    void getSamePositionCarNotExistTest() {
        compareCar = new Car("compareCar", 5);

        Assertions.assertThat(car.getSamePositionCar(compareCar)).isEqualTo(null);
    }
}