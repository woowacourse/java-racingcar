package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class RoundNumberValidatorTest {
    @Test
    void 음수_체크() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("-23"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값이_0일경우_체크() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 소수의_경우_체크() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("1.33"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_경우_체크() {
        assertThatThrownBy(() -> RoundNumberValidator.validate("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
