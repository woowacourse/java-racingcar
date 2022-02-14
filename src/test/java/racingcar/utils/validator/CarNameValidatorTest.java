package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {
    @Test
    @DisplayName("이름 글자 초과시 예외 발생")
    void overNameLength() {
        assertThatThrownBy(() -> CarNameValidator.validate("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 빈 문자열일 경우 예외 발생")
    void emptyName() {
        assertThatThrownBy(() -> CarNameValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 whitespace 경우 예외 발생")
    void whitespaceName() {
        assertThatThrownBy(() -> CarNameValidator.validate("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
