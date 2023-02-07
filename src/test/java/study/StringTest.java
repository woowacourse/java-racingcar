package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringTest {

    @Test
    void split_메서드_테스트() {
        String str = "1,2";
        assertThat(str.split(",")).containsExactly("1", "2");
    }

    @Test
    void split_메서드_테스트2() {
        String str = "1";
        assertThat(str.split(",")).containsExactly("1");
    }

    @Test
    void String_메서드로_괄호를_제거() {
        String str = "(1,2)";
        assertThat(str.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    void String_메서드로_특정_위치_문자_가져오기() {
        String input = "abc";

        int minInputLength = 0;

        assertThatThrownBy(() -> {
            input.charAt(minInputLength - 1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }


}
