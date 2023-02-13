package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertUtilsTest {
    @DisplayName("Null이 존재하는 경우 예외 발생")
    @Test
    void assertNullTest() {
        assertThatThrownBy(() ->
                AssertUtils.assertNull(null)
        ).isInstanceOf(NullPointerException.class);
    }
}
