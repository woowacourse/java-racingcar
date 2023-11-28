package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        // given
        String s = "1,2";

        // when
        String[] split = s.split(",");

        // then
        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
    }

    @Test
    void substringTest() {
        // given
        String s = "(1,2)";

        // when
        String result = s.substring(1, s.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chatAtTest() {
        // given
        String input = "abc";

        // when
        char result = input.charAt(0);

        // then
        assertThat(result).isEqualTo('a');
    }

    @Test
    void stringIndexOutOfBoundsExceptionTest() {
        // given
        String input = "abc";

        // when
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
