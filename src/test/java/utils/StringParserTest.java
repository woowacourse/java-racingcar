package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

class StringParserTest {
    @Test
    void parseTest1() {
        //given
        String input = "pobi,crong,honux";

        //when
        List<String> parse = StringParser.splitByComma(input);

        //then
        assertThat(parse).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void parseTest2() {
        //given
        String input = "a,,,";

        //when
        List<String> parse = StringParser.splitByComma(input);

        //then
        assertThat(parse).containsExactly("a", "", "", "");
    }
}