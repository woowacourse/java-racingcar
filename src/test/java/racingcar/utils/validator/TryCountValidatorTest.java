package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class TryCountValidatorTest {

    @Test
    void 시도_회수_문자() {
        String tryCount = "q";
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }

    @Test
    void 시도_횟수_음수() {
        String tryCount = "-1";
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }

    @Test
    void 시도_횟수_공백() {
        String tryCount = "";
        assertThatThrownBy(() -> {
            TryCountValidator.validateTryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 양수만 가능합니다.");
    }
}
