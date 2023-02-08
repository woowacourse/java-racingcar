package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    void splitTest1() {
        // given
        String input = "1,2";

        // when
        String[] split = input.split(",");

        // then
        assertThat(split).contains("2", "1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        // given
        String input = "1";

        // when
        String[] split = input.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substringTest() {
        // given
        String input = "(1,2)";

        // when
        String substring = input.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다.")
    @CsvSource({"0,a", "1,b", "2,c"})
    @ParameterizedTest
    void charAtTest(int index, char expected) {
        //given
        String input = "abc";

        // when
        char c = input.charAt(index);

        //then
        assertThat(c).isEqualTo(expected);
    }

    @DisplayName("범위를 벗어난 문자를 가져온다.")
    @CsvSource({"-1", "3"})
    @ParameterizedTest
    void charAtExceptionTest(int index) {
        //given
        String input = "abc";
        //when

        //then
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
