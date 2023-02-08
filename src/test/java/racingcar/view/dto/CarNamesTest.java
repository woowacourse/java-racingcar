package racingcar.view.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {
    @DisplayName("자동차 이름에는 문자와 숫자만 들어갈 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,ba, ,abs", ",a,b", "a c v"})
    void validateFormatTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}