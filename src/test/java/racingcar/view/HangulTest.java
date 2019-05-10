package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HangulTest {
    @Test
    void ITestKor() {
        assertThat(Hangul.differentiateIGa("목마른 사슴")).isEqualTo("이");
    }

    @Test
    void ITestEng() {
        assertThat(Hangul.differentiateIGa("Well")).isEqualTo("이");
    }

    @Test
    void GaTestKor() {
        assertThat(Hangul.differentiateIGa("가가가가")).isEqualTo("가");
    }

    @Test
    void GaTestEng() {
        assertThat(Hangul.differentiateIGa("AAAA")).isEqualTo("가");
    }
}