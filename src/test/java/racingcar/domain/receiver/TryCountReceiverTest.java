package racingcar.domain.receiver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.receiver.TryCountReceiver;
import racingcar.exception.TryCountException;

public class TryCountReceiverTest {

    private TryCountReceiver parser;

    @BeforeEach
    void setUp() {
        parser = new TryCountReceiver();
    }

    @Test
    public void 문자열을_숫자로_변환() {
        assertThat(parser.parseTryCount("1")).isEqualTo(1);
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> parser.validateTryCount("-1"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.NEGATIVE_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "실수의 경우 예외 발생 - 입력값 : {0}")
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> parser.validateTryCount(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.FLOAT_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> parser.validateTryCount("0"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.ZERO_TRY_COUNT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "빈 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " ", "        "})
    public void 빈공백일때_예외_발생(String input) {
        assertThatThrownBy(() -> parser.validateTryCount(input))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.BLANK_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 널일때_예외_발생() {
        assertThatThrownBy(() -> parser.validateTryCount(null))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.NULL_TRY_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 문자일때_예외_발생() {
        assertThatThrownBy(() -> parser.validateTryCount("abcd"))
                .isInstanceOf(TryCountException.class)
                .hasMessageContaining(TryCountReceiver.CHARACTER_TRY_COUNT_ERROR_MESSAGE);
    }
}
