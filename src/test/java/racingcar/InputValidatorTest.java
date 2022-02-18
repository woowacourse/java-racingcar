package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    void 자동차의_이름이_5자_이상인_경우_예외처리() {
        assertThatThrownBy(() -> {
            InputValidator.validateCarNameLength(Arrays.asList("asd","qwerty"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
