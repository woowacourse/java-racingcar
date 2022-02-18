package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.TryCountException;
import racingcar.validator.TryCountSettingValidator;

public class TryCountSettingValidatorTest {

    private TryCountSettingValidator tryCountSettingValidator;

    @BeforeEach
    public void setUp() {
        tryCountSettingValidator = new TryCountSettingValidator();
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> tryCountSettingValidator.validate("-1"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.NEGATIVE_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "실수의 경우 예외 발생 - 입력값 : {0}")
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountSettingValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.FLOAT_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> tryCountSettingValidator.validate("0"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.ZERO_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "빈 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " ", "        "})
    public void 빈공백일때_예외_발생(String input) {
        assertThatThrownBy(() -> tryCountSettingValidator.validate(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.BLANK_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 널일때_예외_발생() {
        assertThatThrownBy(() -> tryCountSettingValidator.validate(null))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.NULL_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자일때_예외_발생() {
        assertThatThrownBy(() -> tryCountSettingValidator.validate("abcd"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountSettingValidator.CHARACTER_TRY_COUNT_ERROR_MESSAGE);
    }
}
