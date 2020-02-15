package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerUtilsTest {
    @DisplayName("예외 케이스 테스트: 입력값이 숫자가 아닌 경우")
    @Test
    void 입력값이_숫자가_아닌_경우() {
        assertThatThrownBy(() -> {
            IntegerUtils.stringToInt("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다");
    }
}
