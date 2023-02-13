package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car;
    Car compareCar;

    @BeforeEach
    void generateCar() {
        car = new Car("test", 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"이오이오이오", "재이재이재이재이재이"})
    @DisplayName("자동차 이름이 5글자 초과인 경우")
    void wrongCarNameLengthTest(String carName) {

        Assertions.assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 빈 값인 경우")
    void carNameBlankTest() {
        String carName = "";

        Assertions.assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "6:true", "7:true"}, delimiter = ':')
    @DisplayName("자동차 전진 여부 결정 기능 테스트")
    void carCanMovingTest(int power, boolean expected) {
        Assertions.assertThat(car.canMoving(power)).isEqualTo(expected);
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

        Assertions.assertThat(car.compareTo(compareCar)).isLessThan(0);
    }

    @Test
    @DisplayName("Position이 같은 자동차가 있을 경우 테스트")
    void getSamePositionCarExistTest() {
        compareCar = new Car("compareCar", 0);

        Assertions.assertThat(car.isSamePositionCar(compareCar)).isTrue();
    }

    @Test
    @DisplayName("Position이 같은 자동차가 없을 경우 테스트")
    void getSamePositionCarNotExistTest() {
        compareCar = new Car("compareCar", 5);

        Assertions.assertThat(car.isSamePositionCar(compareCar)).isFalse();
    }
}
