package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    void split1() {
        String value = "1,2";
        String separator = ",";

        int testIndexOne = 0;
        int testIndexTwo = 1;

        String expectResultOne = "1";
        String expectResultTwo = "2";

        assertThat(value.split(separator)[testIndexOne]).contains(expectResultOne);
        assertThat(value.split(separator)[testIndexTwo]).contains(expectResultTwo);

        assertThat(value.split(separator)).containsExactly(expectResultOne, expectResultTwo);
    }

    @Test
    void split2() {
        String value = "1";
        String separator = ",";

        int testIndexOne = 0;

        String[] values = value.split(separator);
        String expectResultOne = "1";

        assertThat(values[testIndexOne]).contains(expectResultOne);
        assertThat(values).containsExactly(expectResultOne);
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String newValue = value.substring(1, 4);

        assertThat(newValue).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 특정 위치의 값 반환 테스트")
    void charAt() {
        String value = "abc";
        int testIndex = 2;

        assertThat(value.charAt(testIndex)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열의 올바르지 않은 위치 호출 시 예외 처리")
    void charAtException() {
        String value = "abc";
        int testIndex = 4;
        final String expectMessage = "String index out of range: ";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(testIndex);
                }).withMessageMatching(expectMessage + "\\d+");

        assertThatThrownBy(() -> {
            value.charAt(testIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(expectMessage + testIndex);
    }
}
