package view.input;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @MethodSource("parameterProviderWhenFail")
    void validateCarNameWithFailureCaseTest(List<String> splitCarName) {
        assertThatThrownBy(() -> inputValidator.validateCarName(splitCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> parameterProviderWhenFail() {
        return Stream.of(
                Arguments.of(List.of("pobi", " ")),
                Arguments.of(List.of("g", "\n")),
                Arguments.of(List.of(" h", " h"))
                );
    }

    @ParameterizedTest
    @MethodSource("parameterProviderWhenSuccess")
    void validateCarNameWithSuccessCaseTest(List<String> splitCarName) {
        assertThatCode(() -> inputValidator.validateCarName(splitCarName))
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
    void validateGameTryWithFailureCaseTest(String gameTry) {
        assertThatThrownBy(() -> inputValidator.validateGameTry(gameTry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000", "5000"})
    void validateGameTryWithSuccessCaseTest(String gameTry) {
        assertThatCode(() -> inputValidator.validateGameTry(gameTry))
                .doesNotThrowAnyException();
    }
}
