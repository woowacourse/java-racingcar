package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundNumberValidatorTest {

    @Test
    @DisplayName("자연수가 아닐 경우 예외처리 - 0")
    void checkZeroOrPositiveNumber_0() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닐 경우 예외처리 - 실수")
    void checkZeroOrPositiveNumber_double() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("1.33"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닐 경우 예외처리 - 문자")
    void checkZeroOrPositiveNumber_string() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닐 경우 예외처리 - 음수")
    void checkZeroOrPositiveNumber_negativeNumber() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("-23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
