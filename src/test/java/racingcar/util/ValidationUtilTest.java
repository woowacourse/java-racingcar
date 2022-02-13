package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import static racingcar.util.ValidationUtil.*;

class ValidationUtilTest {

    @Test
    @DisplayName("자동차 이름을 입력하지 않은 경우 예외 발생")
    public void carNameMustNotBeEmpty() {
        assertThatThrownBy(() -> validateCarName("", 0, 5))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateCarName(null, 0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백을 포함하는 자동차 이름을 입력한 경우 예외 발생")
    public void carNameMustNotContainBlank() {
        assertThatThrownBy(() -> validateCarName("w o", 0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다섯 글자 이상의 자동차 이름을 입력한 경우 예외 발생")
    public void carNameMustLessThanFiveLetters() {
        assertThatThrownBy(() -> validateCarName("wooteco", 0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    public void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> isDuplicated(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

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