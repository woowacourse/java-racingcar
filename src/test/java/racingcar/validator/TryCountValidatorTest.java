package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.validator.TryCountValidator;

public class TryCountValidatorTest {
    @Test
    void 시도_회수_문자() {
        String tryCount = "q";
        assertThatThrownBy(() -> {
            TryCountValidator.validatePattern(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 시도 회수는 양수만 가능합니다.");
    }

    @Test
    void 시도_횟수_음수() {
        String tryCount = "-1";
        assertThatThrownBy(() -> {
            TryCountValidator.validatePattern(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 시도 회수는 양수만 가능합니다.");
    }

    @Test
    void 시도_횟수_공백() {
        String tryCount = "";
        assertThatThrownBy(() -> {
            TryCountValidator.validatePattern(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 시도 회수는 양수만 가능합니다.");
    }
}
