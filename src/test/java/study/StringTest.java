package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String.split 성공 테스트")
    void testSuccessSplitString() {
        final String testString = "1,2";
        final String testSaparator = ",";
        final int firstIndex = 0;
        final int secondIndex = 1;
        final String firstExpectResult = "1";
        final String secondExpectResult = "2";

        assertThat(testString.split(testSaparator)[firstIndex]).isEqualTo(firstExpectResult);
        assertThat(testString.split(testSaparator)[secondIndex]).isEqualTo(secondExpectResult);
        assertThat(testString.split(testSaparator))
            .containsExactly(firstExpectResult, secondExpectResult);
    }

    @Test
    @DisplayName("String.split 특수 상황 테스트")
    void testUnusualSplitString() {
        final String testString = "1";
        final String testSaparator = ",";
        final int firstIndex = 0;
        final String expectResult = "1";

        assertThat(testString.split(testSaparator)).contains(expectResult);
        assertThat(testString.split(testSaparator)).containsExactly(expectResult);
        assertThat(testString.split(testSaparator)[firstIndex]).isEqualTo(expectResult);
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
