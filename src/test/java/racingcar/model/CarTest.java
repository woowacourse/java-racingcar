package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름에는 null 값이나, 1~5 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "123456"})
    void exceptionCreateCar(String carName) {
        //given, when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 1~5자로 입력해주세요.");
    }

    @DisplayName("자동차를 생성하면 위치 초기값은 0이다.")
    @Test
    void confirmPosition() {
        //given
        String carName = "ted";
        int expectedPosition = 0;

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("4보다 큰 숫자일 경우 전진, 작을 경우 전진하지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    void confirmMove(int given, int expected) {
        //given
        String name = "daon";

        //when
        Car car = new Car(name);
        car.move(given);

        //then
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}