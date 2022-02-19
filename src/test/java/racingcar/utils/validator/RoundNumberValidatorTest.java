package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1.33", "abc", "-23"})
    @DisplayName("자연수가 아닐 경우 예외처리")
    void checkZeroOrPositiveNumber(String round) {
        assertThatThrownBy(() -> RoundNumberValidator.validate(round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
