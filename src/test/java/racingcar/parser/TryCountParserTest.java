package racingcar.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.parser.exception.TryCountException;

public class TryCountParserTest {

    private TryCountParser parser;

    @BeforeEach
    void setUp() {
        parser = new TryCountParser();
    }

    @Test
    public void 문자열을_숫자로_변환() {
        assertThat(parser.parse("1")).isEqualTo(1);
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> parser.parse("-1"))
            .isInstanceOf(TryCountException.class)
            .hasMessageContaining("시도 횟수는 음수가 될 수 없습니다.");
    }

    @ParameterizedTest(name = "실수의 경우 예외 발생 - 입력값 : {0}")
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(TryCountException.class)
            .hasMessageContaining("시도 횟수는 실수가 될 수 없습니다.");
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> parser.parse("0"))
            .isInstanceOf(TryCountException.class)
            .hasMessageContaining("시도 횟수는 0이 될 수 없습니다.");
    }

    @ParameterizedTest(name = "빈 공백일 경우 예외 발생")
    @ValueSource(strings = {"", " ", "        "})
    public void 빈공백일때_예외_발생(String input) {
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(TryCountException.class)
            .hasMessageContaining("시도 횟수는 공백일 수 없습니다.");
    }

    @Test
    public void 널일때_예외_발생() {
        assertThatThrownBy(() -> parser.parse(null))
            .isInstanceOf(TryCountException.class)
            .hasMessageContaining("시도 횟수는 NULL값일 수 없습니다.");
    }
}
