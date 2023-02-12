package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    void 값이_2개_이상인_문자열_분리() {
        String input = "1,2";
        String result[] = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 값이_하나인_문자열_분리() {
        String input = "1";
        String result[] = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void 문자열_괄호_제거() {
        String input = "(1,2)";
        String result = input.replaceAll("[()]", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치의 문자가 범위 안에 있는 경우")
    void 문자열_범위_안의_문자_가져오기() {
        String input = "abc";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열에서 특정 위치의 문자가 범위 밖에 있는 경우")
    void 문자열_범위_밖의_문자_가져오기() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}