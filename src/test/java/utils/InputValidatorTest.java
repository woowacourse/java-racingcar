package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.ErrorMessage.NOT_NUMBER;
import static utils.ErrorMessage.NOT_POSITIVE_NUMBER;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {



    static Stream<Arguments> invalidTryNumber() {
        return Stream.of(
                Arguments.of("배키","시도 횟수가 숫자가 아니다.", NOT_NUMBER),
                Arguments.of("-1","시도 횟수가 음수이다.", NOT_POSITIVE_NUMBER),
                Arguments.of(" ","시도 횟수가 빈 문자이다.", NOT_NUMBER)
        );
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("시도 횟수 예외 발생")
    @MethodSource("invalidTryNumber")
    public void invalidTryNumberThrowException(String tryNumber, String reason, String errorMessage) {
        assertThatThrownBy(() -> InputValidator.tryNumberValidator(tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

}