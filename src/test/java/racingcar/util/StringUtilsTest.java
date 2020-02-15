package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @DisplayName("예외 케이스 테스트: Null 혹은 Empty 값 입력")
    @ParameterizedTest
    @NullAndEmptySource
    void 입력값_Null_Or_Empty(String input) {
        assertThatThrownBy(() -> {
            StringUtils.validNullOrEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.(Null or Empty)");
    }
}

