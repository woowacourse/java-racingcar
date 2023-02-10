package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2과 들어오면 1과 2가 포함되어야한다.")
    void splitTest() {
        String string = "1,2";
        String[] split = string.split(",");

        assertThat(split).contains("1")
                .contains("2")
                .containsExactly("1", "2");

    }

    @Test
    @DisplayName("1만 들어오면 1만 포함하는 배열을 반환한다.")
    void singleSplitTest() {
        String string = "1";
        String[] split = string.split(",");

        assertThat(split).contains("1")
                .containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 에서 ( && ) 를 제거하고 1,2를 반환한다.")
    void removeBracket() {
        String string = "(1,2)";
        String replace = string.replace("(", "").replace(")", "");

        assertThat(replace).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자를 가져온다.")
    void checkIndexOf() {
        String string = "abc";
        char result = string.charAt(1);

        char expect = 'b';

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("문자열의 인덱스를 벗어나면 예외던짐")
    void checkIndexOfException() {
        String string = "abc";
        assertThatThrownBy(() -> string.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
