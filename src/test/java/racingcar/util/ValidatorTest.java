package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import racingcar.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "moreThanFive"})
    @DisplayName("차 이름 입력에 대한 예외 테스트")
    void carNameTest(String exceptionCase) {
        assertThatThrownBy(() -> new Car(exceptionCase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"정수아님", "5.5"})
    @DisplayName("게임 시간 정수 제외 입력 예외")
    void gameTimeTest(String sources) {
        assertThatThrownBy(() -> Validator.validateStringToInt(sources))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 시간 양수 검증")
    void validateGameTimeTest() {
        assertThatThrownBy(() -> Validator.validateGameTime(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차를 하나만 입력한 케이스")
    void onlyOneCarException() {
        Car car = new Car("aa");
        List<Car> cars = List.of(car);
        assertThatThrownBy(() -> new RacingGame(1, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름 중복 케이스")
    void carsExceptionCaseTest() {
        Car car1 = new Car("aa");
        Car car2 = new Car("aa");
        List<Car> cars = List.of(car1, car2);
        assertThatThrownBy(() -> new RacingGame(1, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

}