package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    void splitTest1() {
        String input = "1,2";
        String[] split = input.split(",");
        assertThat(split).contains("2", "1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String input = "1";
        String[] split = input.split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String substring = input.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다.")
    @CsvSource({"0,a", "1,b", "2,c"})
    @ParameterizedTest
    void charAtTest(int index, char expected) {
        String input = "abc";
        char c = input.charAt(index);
        assertThat(c).isEqualTo(expected);
    }

    @DisplayName("범위를 벗어난 문자를 가져온다.")
    @CsvSource({"-1", "3"})
    @ParameterizedTest
    void charAtExceptionTest(int index) {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
