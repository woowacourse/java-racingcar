package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("문자열 구분자 split 검사")
    public void splitAndSum_comma() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 숫자 하나만 구분자 split 검사")
    public void splitAndSum_single() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("문자열에서 소괄호 제거 검사")
    public void remove_round_brackets() {
        String value = "(1,2)".replaceAll("[()]", "");
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자의 특정 위치 예외 처리")
    public void specific_location() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + 4);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessageMatching("String index out of range: " + 4);
    }
}
