package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void name() {
        String values = "(1,2)".substring(1, 4);
        assertThat(values).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    void name3() {
        assertThatThrownBy(() -> {
            throw new IndexOutOfBoundsException(String.valueOf("abc".charAt(4)));
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("a");
    }
}
