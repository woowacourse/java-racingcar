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
    @DisplayName("String.substring 성공 테스트")
    void testSuccessSubstring() {
        final String testString = "(1,2)";
        final int firstIndex = 1;
        final int secondIndex = 4;
        final String expectResult = "1,2";

        assertThat(testString.substring(firstIndex, secondIndex))
            .isEqualTo(expectResult);
    }

    @Test
    @DisplayName("String.charAt 문자열 특정 위치의 값 반환 테스트")
    void testSuccessCharAt() {
        final String testString = "abc";
        final int testIndex = 2;
        final char expectResult = 'c';

        assertThat(testString.charAt(testIndex)).isEqualTo(expectResult);
    }

    @Test
    @DisplayName("String.charAt 문자열 잘못된 위치 호출시 예외 처리")
    void testCharAtException() {
        final String testString = "abc";
        final int testIndex = 4;
        final String expectMessage = "String index out of range: ";
        final String expectMessageFormat = "\\d+";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                testString.charAt(testIndex);
            }).withMessageMatching(expectMessage + expectMessageFormat);

        assertThatThrownBy(() -> {
            testString.charAt(testIndex);
        })
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(expectMessage + testIndex);
    }
}
