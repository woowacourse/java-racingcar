package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
