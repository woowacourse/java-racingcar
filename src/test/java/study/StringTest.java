package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
    }

    @Test
    public void name() {
        String[] values = "(1,2)".substring(1, 4).split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("주어진 인덱스가 문자열보다 클 때 Exception 발생")
    public void exceptionTest1() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @Test
    @DisplayName("주어진 인덱스가 문자열 보다 쓰면 Exception 발생")
    public void exceptionTest2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessageMatching("String index out of range: \\d");
    }
}