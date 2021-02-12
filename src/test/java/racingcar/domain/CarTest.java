package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @DisplayName("정상적인 이름인 경우 Car 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"중간곰", "다니", "포비", "씨유", "브라운", "harry"})
    public void createCar(String name) {
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 지정된 범위를 벗어난 경우 예외를 발생시킨다")
    @Test
    public void createCarException() {
        final String SHORT_CAR_NAME = "";
        final int MAXIMUM_LENGTH = 5;
        final String LONG_CAR_NAME = new String(new char[MAXIMUM_LENGTH + 1]);

        assertThatThrownBy(() -> {
            new Car(SHORT_CAR_NAME);
            new Car(LONG_CAR_NAME);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    public void moveCar(int random) {
        Car car = new Car("pobi");
        Movable movable = () -> random;

        car.move(movable);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 멈춘다")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    public void stopCar(int random) {
        Car car = new Car("pobi");
        Movable movable = () -> random;

        car.move(movable);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
