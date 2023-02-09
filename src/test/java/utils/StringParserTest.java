package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    void parseTest() {
        //given
        String input = "pobi,crong,honux";

        //when
        List<String> parse = StringParser.splitByComma(input);

        //then
        assertThat(parse).containsExactly("pobi", "crong", "honux");
    }
}