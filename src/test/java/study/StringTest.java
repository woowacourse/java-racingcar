package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings[0]).contains("1");
        assertThat(strings[1]).contains("2");
        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    public void removeParenthesis() {
        String string = "(1,2)";
        String result1 = string.substring(1, string.length() - 1);
        String result2 = string.replaceAll("[()]", "");
        assertThat(result1).isEqualTo("1,2");
        assertThat(result2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("예외사항 확인")
    public void exception() {
        String string = "abc";
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> {
            string.charAt(6);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 6");
    }
}
