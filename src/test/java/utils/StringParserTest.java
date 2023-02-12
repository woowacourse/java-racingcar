package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    void parseTest() {
        String input = "pobi,crong,honux";
        List<String> parse = StringParser.splitByComma(input);
        assertThat(parse).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void parseBlankTest() {
        String input = "a,,,";
        List<String> parse = StringParser.splitByComma(input);
        assertThat(parse).containsExactly("a", "", "", "");
    }
}
