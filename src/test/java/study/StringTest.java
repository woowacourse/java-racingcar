package study;

import org.assertj.core.api.Assertions;
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

    void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @DisplayName("String의 chatAt 기능을 테스트한다")
    @Test
    void charAt() {
        char a = "abc".charAt(0);
        char b = "abc".charAt(1);
        char c = "abc".charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @DisplayName("String에 존재하지 않는 위치를 charAt으로 조회하면 예외를 발생한다")
    @Test
    void chatAtIfNotExistIndexThenThrowException() {

        assertThatThrownBy(() -> "abc".charAt(3))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }

    @DisplayName("String의 indexOf 기능을 테스트한다")
    @Test
    void testIndexOf() {
        String string = "//;\n";
        int startIndex = string.indexOf("//");
        int endIndex = string.indexOf("\n");

        String delimiter = string.substring(endIndex);
        assertThat(delimiter).isEqualTo(";");
    }
}