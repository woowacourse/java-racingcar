package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void replace() {
        String result = "(1,2)"
                .replace("(", "")
                .replace(")", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    class charAt {

        @Test
        @DisplayName("charAt() 성공")
        void success() {
            char result = "abc".charAt(0);
            assertThat(result).isEqualTo('a');
        }

        @Test
        @DisplayName("charAt() 실패")
        void fail() {
            assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
        }
    }
}
