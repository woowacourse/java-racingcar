package view.input;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "abc", " ", "10001", "3.5"})
    void validateGameTryWithFailureCaseTest(String gameTry) {
        assertThatThrownBy(() -> inputValidator.validateGameTryRange(gameTry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000", "5000"})
    void validateGameTryWithSuccessCaseTest(String gameTry) {
        assertThatCode(() -> inputValidator.validateGameTryRange(gameTry))
                .doesNotThrowAnyException();
    }
}
