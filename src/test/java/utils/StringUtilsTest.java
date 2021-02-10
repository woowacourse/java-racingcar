package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    @DisplayName("null isBlank")
    void nullString_isBlank() {
        assertTrue(StringUtils.isBlank(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"","  ","     "})
    @DisplayName("space 로만 구성된 문자열 isBlank")
    void OnlySpaceString_isBlank(String str) {
        assertTrue(StringUtils.isBlank(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd"," asda ","문자열 입니다."})
    @DisplayName("정상입력 isBlank")
    void valid_isBlank(String str) {
        assertFalse(StringUtils.isBlank(str));
    }
}