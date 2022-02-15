package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.CarNameValidationUtil.*;

public class CarNameValidationUtilTest {

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

}
