package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class CarNameValidatorTest {
    @Test
    void 이름_글자수_체크() {
        assertThatThrownBy(() -> CarNameValidator.validate("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_이름_유효성_체크() {
        assertThatThrownBy(() -> CarNameValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_이름_유효성_체크() {
        assertThatThrownBy(() -> CarNameValidator.validate("  "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_null_유효성_체크() {
        assertThatThrownBy(() -> CarNameValidator.validate(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
