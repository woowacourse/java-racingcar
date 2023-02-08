package racingcar.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {
    @DisplayName("자동차 이름에는 문자와 숫자만 들어갈 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,ba, ,abs", ",a,b", "a c v"})
    void validateFormatTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 한글자 이상이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "car1,,car2", ""})
    void validateBlankTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 다섯글자 이하이어야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "car,carscar"})
    void validateOverLengthTest(String input) {
        assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}