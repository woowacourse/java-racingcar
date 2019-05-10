package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    @Test
    void filterTypoTest() {
        assertThat(Validation.filterTypos("asd, dgsad, sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(Validation.filterTypos("asd,     dgsad, sdf,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(Validation.filterTypos("asd,dgsad,sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(Validation.filterTypos("asd, dgsad, sdf,,,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(Validation.filterTypos("asd, dgsad,  sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
    }

    @Test
    void areValidNamesTest() {
        assertThat(Validation.areValidNames(Arrays.asList("asd","dgsad","sdf"))).isTrue();
        assertThat(Validation.areValidNames(Arrays.asList("asd","dgsad","asd"))).isFalse();
        assertThat(Validation.areValidNames(Arrays.asList("asd"))).isFalse();
        assertThat(Validation.areValidNames(Arrays.asList("asd","dgsadsd","asd"))).isFalse();
    }

    @Test
    void isValidNumberTest() {
        assertThat(Validation.isAValidNumber("7")).isTrue();
        assertThat(Validation.isAValidNumber("761353431")).isTrue();
        assertThat(Validation.isAValidNumber("-5")).isFalse();
        assertThat(Validation.isAValidNumber("00009")).isTrue();
        assertThat(Validation.isAValidNumber("HG")).isFalse();
    }

    @Test
    void differentiateIGaTest() {
        assertThat(Validation.differentiateIGa('아')).isEqualTo("가");
        assertThat(Validation.differentiateIGa('G')).isEqualTo("가");
        assertThat(Validation.differentiateIGa('누')).isEqualTo("가");
        assertThat(Validation.differentiateIGa('삶')).isEqualTo("이");
        assertThat(Validation.differentiateIGa('놀')).isEqualTo("이");
        assertThat(Validation.differentiateIGa('L')).isEqualTo("이");
    }
}