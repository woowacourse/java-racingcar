package parser;

import domain.Trial;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrialParserTest {

    @Test
    void parse_음인정수() {
        String input = "-1";

        assertThrows(IllegalArgumentException.class, () -> TrialParser.parse(input));
    }

    @Test
    void parse_숫자아닌입력() {
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> TrialParser.parse(input));
    }

    @Test
    void parse_() {
        String input = "13";

        assertThat(TrialParser.parse(input)).isEqualTo(Trial.from(13));
    }
}