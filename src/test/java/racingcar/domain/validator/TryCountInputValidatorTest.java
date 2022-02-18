package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.TryCountException;

public class TryCountInputValidatorTest {

    private TryCountInputValidator tryCountInputValidator;

    @BeforeEach
    public void setUp() {
        tryCountInputValidator = new TryCountInputValidator();
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> tryCountInputValidator.validate("-1"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.NEGATIVE_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "실수의 경우 예외 발생 - 입력값 : {0}")
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountInputValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.FLOAT_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> tryCountInputValidator.validate("0"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.ZERO_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "빈 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " ", "        "})
    public void 빈공백일때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountInputValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.BLANK_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 널일때_예외_발생() {
        assertThatThrownBy(() -> tryCountInputValidator.validate(null))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.NULL_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자일때_예외_발생() {
        assertThatThrownBy(() -> tryCountInputValidator.validate("abcd"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountInputValidator.CHARACTER_TRY_COUNT_ERROR_MESSAGE);
    }
}
