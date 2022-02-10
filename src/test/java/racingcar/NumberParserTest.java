package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberParserTest {
    @Test
    public void 문자열을_숫자로_변환() {
        NumberParser parser = new NumberParser();
        assertThat(parser.parse("1")).isEqualTo(1);
    }
}
