package racingcargame.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void testMultiply() {
        assertThat(StringUtils.multiply("-", 4)).isEqualTo("----");
    }
}