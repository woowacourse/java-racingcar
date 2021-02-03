package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("문자열 분리 테스트")
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 자르기 테스트")
    public void slice() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 인덱스 테스트")
    public void getCharacter() {
        String value = "abc";
        int outIndex = value.length() + 1;

        assertThatThrownBy(() -> {
            value.charAt(outIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(outIndex);
                }).withMessageMatching("String index out of range: " + outIndex);
    }
}
