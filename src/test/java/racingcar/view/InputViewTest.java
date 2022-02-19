package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    @DisplayName("시도 횟수에 정수를 입력하지 않는 경우 예외 발생")
    void attemptMustBeInteger() {
        assertThatThrownBy(() -> InputView.validateIntegerThenParse("문자"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
