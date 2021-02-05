package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");
    }

    @Test
    void substirng() {
        String values = "(1,2)".substring(1,4);
        assertThat(values).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 학습 테스트")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }
}
