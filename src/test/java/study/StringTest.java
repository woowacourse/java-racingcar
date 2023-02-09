package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void stringDoubleSplitTest() {
        //given
        String input = "1,2";

        //when
        final String[] answer = input.split(",");

        //then
        Assertions.assertThat(answer).containsExactly("1", "2");
    }

    @Test
    void stringSingleSplitTest() {
        //given
        String input = "1";

        //when
        final String[] answer = input.split(",");

        //then
        Assertions.assertThat(answer).containsExactly("1");
    }

    @Test
    void stringBracketSplitTest() {
        //given
        String input = "(1,2)";

        //when
        final String answer = input.substring(1, input.length() - 1);

        //then
        assertEquals(answer, "1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오면 StringIndexOutOfBoundsException 에러 발생")
    void specificString_StringIndexOutOfBoundsException() {
        //given
        String input = "abc";

        //when & then

        Assertions.assertThatThrownBy(() -> {
            final String answer1 = input.substring(input.length(), input.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        final String answer2 = input.substring(0, 1);

        assertEquals(answer2, "a");
    }
}
