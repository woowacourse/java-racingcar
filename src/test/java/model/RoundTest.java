package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @DisplayName("시도 횟수 입력 값이 자연수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"+4", "ss", "", "   ", "-1", "3.2", "0"})
    void roundValidationTest(String input) {
        assertThatThrownBy(() -> Round.from(input)).
                isInstanceOf(IllegalArgumentException.class);
    }
}
