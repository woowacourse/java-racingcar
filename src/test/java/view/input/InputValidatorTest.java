package view.input;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("parameterProviderWhenFail")
    @DisplayName("입력받은 자동차 이름들이 공백이거나 중복되면 예외를 던진다.")
    void validateCarNameWithFailureCaseTest(List<String> splitCarName) {
        assertThatThrownBy(() -> InputValidator.validateCarName(splitCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> parameterProviderWhenFail() {
        return Stream.of(
                Arguments.of(List.of("pobi", " ")),
                Arguments.of(List.of("g", "\n")),
                Arguments.of(List.of(" h", " h")),
                Arguments.of(List.of("haddddy", "haddddy"))
                );
    }

    @ParameterizedTest
    @MethodSource("parameterProviderWhenSuccess")
    @DisplayName("입력받은 자동차 이름들이 공백이 없고 중복되지 않으면 예외를 던지지 않는다.")
    void validateCarNameWithSuccessCaseTest(List<String> splitCarName) {
        assertThatCode(() -> InputValidator.validateCarName(splitCarName))
                .doesNotThrowAnyException();
    }

    private Stream<Arguments> parameterProviderWhenSuccess() {
        return Stream.of(
                Arguments.of(List.of("pobi", "qwe")),
                Arguments.of(List.of("q", "abcde"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "abc", " ", "10001", "3.5"})
    @DisplayName("입력받은 레이싱게임 시도 횟수가 정수 1 ~ 10000 이외의 값이 아니면 예외를 던진다.")
    void validateGameTryWithFailureCaseTest(String gameTry) {
        assertThatThrownBy(() -> InputValidator.validateGameTry(gameTry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000", "5000"})
    @DisplayName("입력받은 레이싱게임 시도 횟수가 정수 1 ~ 10000 사이(양쪽 끝 값 포함)의 값이면 예외를 던지지 않는다.")
    void validateGameTryWithSuccessCaseTest(String gameTry) {
        assertThatCode(() -> InputValidator.validateGameTry(gameTry))
                .doesNotThrowAnyException();
    }
}
