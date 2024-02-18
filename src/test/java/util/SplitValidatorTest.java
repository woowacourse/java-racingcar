package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitValidatorTest {
    @DisplayName("입력이 구분자로 시작하거나 끝나면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {",a", "a,", ",a,", ",,a", "a,,"})
    void validateStartsOrEndsWithDelimiterTest(String input) {
        assertThatThrownBy(() -> SplitValidator.validate(input, ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 구분자 ,로 시작하거나 끝날 수 없습니다.");
    }

    @DisplayName("입력이 구분자로 시작하거나 끝나지 않으면 예외를 던지지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "a,b", "a,b,c"})
    void validateNotStartsAndEndsWithDelimiterTest(String input) {
        assertThatCode(() -> SplitValidator.validate(input, ","))
                .doesNotThrowAnyException();
    }
}
