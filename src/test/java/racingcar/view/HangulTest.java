package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HangulTest {
    @Test
    void ITest() {
        assertThat(Hangul.differentiateIGa("목마른 사슴")).isEqualTo("이");
    }

    @Test
    void GaTest() {
        assertThat(Hangul.differentiateIGa("가가가가")).isEqualTo("가");
    }
}