package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String values = "(1,2)".substring(1, 4);
        assertThat(values).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String values = "abc";
        assertThat(values.charAt(1)).isEqualTo('b');
    }

    @DisplayName("charAt Test")
    @Test
    void charAtException() {
        assertThatThrownBy(() -> {
            try {
                char values = "abc".charAt(3);
            } catch(Exception e) {
                throw new IndexOutOfBoundsException("Index: 3, Size: 3");
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }
}