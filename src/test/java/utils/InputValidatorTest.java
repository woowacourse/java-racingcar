package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.ErrorMessage.CAR_NAME_IS_BLANK;
import static utils.ErrorMessage.CAR_NAME_TOO_LONG;
import static utils.ErrorMessage.NOT_NUMBER;
import static utils.ErrorMessage.NOT_POSITIVE_NUMBER;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    static Stream<Arguments> invalidCarName() {
        return Stream.of(
                Arguments.of(" ","차 이름이 공백이다.", CAR_NAME_IS_BLANK),
                Arguments.of("","차 이름이 빈 문자열이다.", CAR_NAME_IS_BLANK),
                Arguments.of("명오배키켬미","차 이름이 5자를 초과한다.", CAR_NAME_TOO_LONG)
        );
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("자동차 이름 예외 발생")
    @MethodSource("invalidCarName")
    public void invalidCarNameThrowException(String carName, String reason, String errorMessage) {
        assertThatThrownBy(() -> InputValidator.carNamesValidator(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

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