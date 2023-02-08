package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("자동차 이름의 길이가 1보다 작거나 5보다 큰 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void throwExceptionWhenLengthOfCarNameOutOfRange(String input) {
        assertThatThrownBy(() ->  new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이가 1이상 5이하이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createCarWhenLengthOfCarNameIsValidate(String input) {
        assertDoesNotThrow(() -> new Car(input));
    }
}