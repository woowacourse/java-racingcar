package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialCountTest {

    @Test
    @DisplayName("입력값이 0일경우 예외를 발생시킨다.")
    void create_zero() {
        String inputTrialCount = "0";
        assertThatThrownBy(() -> new TrialCount(inputTrialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_POSITIVE_DIGIT);
    }

    @Test
    @DisplayName("입력값이 0이상의 양의 정수가 아닌경우 예외를 발생시킨다.")
    void create_negative() {
        String inputTrialCount = "-1";
        assertThatThrownBy(() -> new TrialCount(inputTrialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_POSITIVE_DIGIT);
    }

}
