package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름에는 null 값이나, 1~5 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "123456"})
    void exceptionInvalidInput(String given) {
        //given //when //then
        assertThrows(IllegalArgumentException.class, () -> new Car(given));
    }

    @DisplayName("자동차를 생성하면 위치 초기값은 0이다.")
    @Test
    void createCarByCarName() {
        //given
        String carName = "ted";
        int expectedPosition = 0;

        //when
        Car car = new Car(carName);

        //then
        assertThat(car).hasFieldOrPropertyWithValue("position", expectedPosition);
    }

}