package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void splitString() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    public void deleteString() {
        assertThat("(1,2)".replaceAll("[(|)]", "")).isEqualTo("1,2");
    }

    @Test
    public void pickStringByIndex() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    public void pickStringOutOfRange() {
        assertThatThrownBy(() -> "abc".charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
