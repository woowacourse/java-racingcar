package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] values ="1,2".split(",");
        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    public void charAt() {
        String value = "abc";
        assertThatThrownBy(() -> {
            char c = value.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}