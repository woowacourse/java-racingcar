package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest {

    @Test
    void isInRange() {
        assertThat(StringUtils.isLengthInRange("abc", 1, 5)).isTrue();
        assertThat(StringUtils.isLengthInRange("abcdef", 1, 5)).isFalse();
    }

    @Test
    void isNumberString() {
        assertThat(StringUtils.isNumberString("123")).isTrue();
        assertThat(StringUtils.isNumberString("abc")).isFalse();
    }
}
