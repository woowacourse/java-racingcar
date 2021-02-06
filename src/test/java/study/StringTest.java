package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values[0]).isEqualTo("1");
        assertThat(values[1]).isEqualTo("2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void name() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("위치 반환 성공 메서드")
    void indexSuccess() {
        String value = "abc";
        assertThat(value.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("위치 반환 실패 메서드")
    void indexFailure() {
        String value = "abc";
        assertThatThrownBy(()-> {
            value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 4");
    }
}
