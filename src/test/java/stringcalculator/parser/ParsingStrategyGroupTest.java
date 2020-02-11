package stringcalculator.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParsingStrategyGroupTest {
    @Test
    void name() {
        String input = "1,2,3";
        StringParserGroup stringParser = StringParserGroup.findByInput(input);
        assertThat(stringParser).isEqualTo(StringParserGroup.DEFAULT);
    }

    @Test
    void name1() {
        String input = "//;\n1;2;3";
        StringParserGroup stringParserGroup = StringParserGroup.findByInput(input);
        assertThat(stringParserGroup).isEqualTo(StringParserGroup.CUSTOM);
    }

    @Test
    void name3() {
        String input = "1,2,3";
        StringParserGroup stringParserGroup = StringParserGroup.findByInput(input);
        List<String> result = stringParserGroup.parse();
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void name4() {
        String input = "//;\n1;2;3";
        assertThat(StringParserGroup.findByInput(input).parse()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}