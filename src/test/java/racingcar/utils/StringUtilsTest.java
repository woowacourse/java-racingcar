package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void differentiateIGaTest() {
        assertThat(StringUtils.differentiateIGa('아')).isEqualTo("가");
        assertThat(StringUtils.differentiateIGa('G')).isEqualTo("가");
        assertThat(StringUtils.differentiateIGa('누')).isEqualTo("가");
        assertThat(StringUtils.differentiateIGa('삶')).isEqualTo("이");
        assertThat(StringUtils.differentiateIGa('놀')).isEqualTo("이");
        assertThat(StringUtils.differentiateIGa('L')).isEqualTo("이");
    }
}
