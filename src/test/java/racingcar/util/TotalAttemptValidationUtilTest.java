package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.TotalAttemptValidationUtil.validateAttempt;

public class TotalAttemptValidationUtilTest {

    @Test
    @DisplayName("시도 횟수에 정수를 입력하지 않는 경우 예외 발생")
    public void attemptMustBeInteger() {
        assertThatThrownBy(() -> validateAttempt("문자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수에 음수를 입력한 경우 예외 발생")
    public void attemptMustBePositive() {
        assertThatThrownBy(() -> validateAttempt("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
