package stringcalculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParsingStrategyGroupTest {

    @DisplayName("Default문자열을 넣으면 Default parsingStrategy가 반환되는지 테스트")
    @Test
    void name() {
        String input = "1,2,3";
        StringParserGroup stringParser = StringParserGroup.findByInput(input);
        assertThat(stringParser).isEqualTo(StringParserGroup.DEFAULT);
    }

    @DisplayName("Custom문자열을 넣으면 custom parsingStrategy가 반환되는지 테스트")
    @Test
    void name1() {
        String input = "//;\n1;2;3";
        StringParserGroup stringParserGroup = StringParserGroup.findByInput(input);
        assertThat(stringParserGroup).isEqualTo(StringParserGroup.CUSTOM);
    }

    @DisplayName("Default문자열을 넣어 제대로 parsing해서 List로 반환되는지 테스트")
    @Test
    void name3() {
        String input = "1,2,3";
        StringParserGroup stringParserGroup = StringParserGroup.findByInput(input);
        List<String> result = stringParserGroup.parse();
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("Custom문자열을 넣어 제대로 parsing해서 List로 반환되는지 테스트")
    @Test
    void name4() {
        String input = "//;\n1;2;3";
        assertThat(StringParserGroup.findByInput(input).parse()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}