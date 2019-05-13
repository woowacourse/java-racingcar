package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest {

    @Test
    void isCarNameLength() {
        assertThat(StringUtils.isCarNameLength("abc")).isTrue();
        assertThat(StringUtils.isCarNameLength("abcdef")).isFalse();
    }

    @Test
    void isNumberString() {
        assertThat(StringUtils.isNumberString("123")).isTrue();
        assertThat(StringUtils.isNumberString("abc")).isFalse();
    }
}
