package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.RacingGameValidationUtil.isDuplicated;
import static racingcar.util.TotalAttemptValidationUtil.validateAttempt;

class RacingGameValidationUtilTest {

    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    public void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> isDuplicated(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}