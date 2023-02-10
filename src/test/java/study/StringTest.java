package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ParameterizedTest(name = "\"1,2\"를 ',' 문자로 문자열 나누기 테스트(contains) - 기대값 : {0}")
    @ValueSource(strings = {"1", "2",})
    void splitContainsTest(String expectedValue) {
        String str = "1,2";
        assertThat(str.split(",")).contains(expectedValue);
    }

    @Test
    @DisplayName("문자로 문자열 나누기 테스트 - 다른 값을 포함하지 않는지 테스트")
    void splitContainsExceptionTest() {
        String str = "1,2";
        assertThat(str.split(",")).doesNotContain("3");
    }

    @Test
    @DisplayName("문자열 나누기 테스트")
    void splitContainsExactlyTest() {
        assertThat("1,2".split(",")).containsExactly("1","2");
    }

    @Test
    @DisplayName("문자열 앞,뒤 문자 제거 테스트")
    void substringTest() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "\"abc\" 문자열의 특정 위치의 문자 가져오기 테스트 : {0} - {1}")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void stringCharAtTest(int index, char expectedValue) {
        String str = "abc";
        assertThat(str.charAt(index)).isEqualTo(expectedValue);
    }

    @Test
    void stringIndexOutOfBoundsExceptionTest() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
    }
}

