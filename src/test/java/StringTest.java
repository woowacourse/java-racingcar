import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest() {
        assertThat("1,2".split(",")).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void splitTest2() {
        assertThat("1".split(",")).isEqualTo(new String[]{"1"});
    }

    @Test
    public void substringTest() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value.split(",")).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void charAtTest() {
        assertThatThrownBy(
                () -> {
                    "abc".charAt(3);
                }
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
