package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void 쉼표구분자() {
        String[] strings = "1,2".split(",");
        assertThat(strings).containsExactly("1", "2");

        strings = "1".split(",");
        assertThat(strings).contains("1");
    }

    @Test
    void 괄호제거() {
        String str = "(1,2)".substring(1, 4);
        assertThat(str).contains("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 테스트하기")
    void 특정_위치의_문자() {
        char ch = "abc".charAt(1);
        assertThat(ch).isEqualTo('b');
    }

    @Test
    void 특정_위치를_벗어난_문자() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
