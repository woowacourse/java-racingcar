package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    void parseTest() {
        //given
        String input = "pobi,crong,honux";

        //when
        List<String> parse = StringParser.parse(input);

        //then
        assertThat(parse).containsExactly("pobi", "crong", "honux");
    }
}