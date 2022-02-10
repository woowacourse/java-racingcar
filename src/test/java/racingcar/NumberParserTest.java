package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberParserTest {

    private NumberParser parser;

    @BeforeEach
    void setUp() {
        parser = new NumberParser();
    }

    @Test
    public void 문자열을_숫자로_변환() {
        assertThat(parser.parse("1")).isEqualTo(1);
    }

    @Test
    public void 음수_숫자_예외_발생() {
        assertThatThrownBy(() -> parser.parse("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.234", "-123.2345", "+12.674"})
    public void 자연수가_아닐때_예외_발생(String input) {
        assertThatThrownBy(() -> parser.parse(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자열이_0일때_예외_발생() {
        assertThatThrownBy(() -> parser.parse("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
