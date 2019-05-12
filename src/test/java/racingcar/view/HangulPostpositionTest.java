package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HangulPostpositionTest {
    @Test
    void ITestKor() {
        assertThat(HangulPostposition.differentiateIGa("목마른 사슴")).isEqualTo("이");
    }

    @Test
    void ITestEng() {
        assertThat(HangulPostposition.differentiateIGa("Well")).isEqualTo("이");
    }

    @Test
    void GaTestKor() {
        assertThat(HangulPostposition.differentiateIGa("가가가가")).isEqualTo("가");
    }

    @Test
    void GaTestEng() {
        assertThat(HangulPostposition.differentiateIGa("a, f")).isEqualTo("가");
    }
}