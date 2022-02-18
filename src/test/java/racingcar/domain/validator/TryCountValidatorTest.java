package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.TryCountException;

public class TryCountValidatorTest {

    private TryCountValidator tryCountValidator;

    @BeforeEach
    public void setUp() {
        tryCountValidator = new TryCountValidator();
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> tryCountValidator.validate("-1"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.NEGATIVE_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "실수의 경우 예외 발생 - 입력값 : {0}")
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.FLOAT_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> tryCountValidator.validate("0"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.ZERO_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "빈 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " ", "        "})
    public void 빈공백일때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.BLANK_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 널일때_예외_발생() {
        assertThatThrownBy(() -> tryCountValidator.validate(null))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.NULL_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자일때_예외_발생() {
        assertThatThrownBy(() -> tryCountValidator.validate("abcd"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountValidator.CHARACTER_TRY_COUNT_ERROR_MESSAGE);
    }
}
