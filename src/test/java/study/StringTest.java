package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");

        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] values = "1".split(",");

        assertThat(values.length).isEqualTo(1);
        assertThat(values[0]).isEqualTo("1");
    }

    @Test
    public void substring() {
        String value = "(1,2)".substring(1, 4);

        assertThat(value).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자 찾기")
    @Test
    void getChar() {
        String value = "abc";

        assertThat(value.charAt(1)).isEqualTo('b');
    }

    @DisplayName("특정 위치의 문자 찾기 에러")
    @Test
    void getCharException() {
        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @DisplayName("특정 위치의 문자 찾기 에러")
    @Test
    void getCharException2() {
        String value = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
