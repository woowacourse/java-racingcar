package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void splitAndSum_comma() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    public void splitAndSum_single() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    public void remove_round_brackets() {
        String value = "(1,2)".replace("(", "")
            .replace(")", "");
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
