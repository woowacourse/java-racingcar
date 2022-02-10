package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split 함수로 주어진 값을 구분할 수 있다.")
    void splitTestContains() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 함수로 구분자가 포함되지 않은 경우, 값을 그대로 반환한다.")
    void splitTestContainsOnly1() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring으로 특정 구간 값을 반환한다.")
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 인덱스로 특정 문자 찾는다.")
    void stringCharAtTest() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열의 길이보다 큰 숫자로 위치를 찾을 때 예외를 발생한다.")
    void stringCharAtExceptionTest() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(5))
            .withMessageMatching("String index out of range: \\d+");
    }
}
