package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @DisplayName("SplitByComma 메서드는 input 값을 pobi, crong, honux로 분리시킨다")
    @Test
    void should_SeparateWordAppropriately_When_UsingSplitByCommaMethod() {
        //given
        String input = "pobi,crong,honux";

        //when
        List<String> parse = StringParser.splitByComma(input);

        //then
        assertThat(parse).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("SplitByComma 메서드는 콤마가 연속으로 와도, 이를 빈 문자열로 분리시킬 수 있다")
    @Test
    void should_SeparateConsecutiveCommasAppropriately_When_UsingSplitByCommaMethod() {
        //given
        String input = "a,,,";

        //when
        List<String> parse = StringParser.splitByComma(input);

        //then
        assertThat(parse).containsExactly("a", "", "", "");
    }
}
