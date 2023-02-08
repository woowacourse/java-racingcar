package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @ParameterizedTest(name = "\"1,2\"를 ',' 문자로 문자열 나누기 테스트(contains) - 기대값 : {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void splitContainsTest(String expectedValue) {
        String str = "1,2";
        assertThat(str.split(",")).contains(expectedValue);
    }

    @ParameterizedTest(name = "',' 문자로 문자열 나누기 테스트(containsExactly) - 입력값 : {0}")
    @ValueSource(strings = {"1,2", "1"})
    void splitContainsExactlyTest(String str) {
        assertThat(str.split(",")).containsExactly("1");
    }
}

