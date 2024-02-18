package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputNumberValidatorTest {

    static Stream<Arguments> invalidTryNumber() {
        return Stream.of(
                Arguments.of("배키", "시도 횟수가 숫자가 아니다.", "시도 횟수가 숫자가 아닙니다."),
                Arguments.of("-1", "시도 횟수가 음수이다.", "시도 횟수가 양수가 아닙니다."),
                Arguments.of(" ", "시도 횟수가 빈 문자이다.", "시도 횟수가 숫자가 아닙니다.")
        );
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("시도 횟수 입력 시 아래 경우에 예외가 발생한다")
    @MethodSource("invalidTryNumber")
    public void invalidTryNumberThrowException(String tryNumber, String reason, String errorMessage) {
        assertThatThrownBy(() -> InputNumberValidator.validatePositiveNumber(tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

}
