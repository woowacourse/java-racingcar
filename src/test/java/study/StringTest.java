package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        // 순서에 상관없이 포함되어 있는지 확인
        assertThat(values).contains("1", "2");
        // 순서대로 값이 정확하게 포함되어 있는지 확인
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void name() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void getCharacter() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                value.charAt(4);
            }).withMessageMatching("String index out of range: 4");
    }
}