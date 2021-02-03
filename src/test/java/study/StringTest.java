package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
        assertThat(values).contains("1");
    }

    @Test
    public void name() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    public void nthLetter() {
        char value = "abc".charAt(1);
        assertThat(value).isEqualTo('b');
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);
//                .hasMessageContaining("abc");
    }





}
