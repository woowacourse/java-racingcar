package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

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

}