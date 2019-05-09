package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class IOValidationTest {
    @Test
    void filterTypoTest() {
        assertThat(IOValidation.filterTypos("asd, dgsad, sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(IOValidation.filterTypos("asd,     dgsad, sdf,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(IOValidation.filterTypos("asd,dgsad,sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(IOValidation.filterTypos("asd, dgsad, sdf,,,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(IOValidation.filterTypos("asd, dgsad,  sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
    }

    @Test
    void areValidNamesTest() {
        assertThat(IOValidation.areValidNames(Arrays.asList("asd","dgsad","sdf"))).isTrue();
        assertThat(IOValidation.areValidNames(Arrays.asList("asd","dgsad","asd"))).isFalse();
        assertThat(IOValidation.areValidNames(Arrays.asList("asd"))).isFalse();
        assertThat(IOValidation.areValidNames(Arrays.asList("asd","dgsadsd","asd"))).isFalse();
    }

    @Test
    void isValidNumberTest() {
        assertThat(IOValidation.isValidNumber("7")).isTrue();
        assertThat(IOValidation.isValidNumber("761353431")).isTrue();
        assertThat(IOValidation.isValidNumber("-5")).isFalse();
        assertThat(IOValidation.isValidNumber("00009")).isTrue();
        assertThat(IOValidation.isValidNumber("HG")).isFalse();
    }

    @Test
    void differentiateIGaTest() {
        assertThat(IOValidation.differentiateIGa('아')).isEqualTo("가");
        assertThat(IOValidation.differentiateIGa('G')).isEqualTo("가");
        assertThat(IOValidation.differentiateIGa('누')).isEqualTo("가");
        assertThat(IOValidation.differentiateIGa('삶')).isEqualTo("이");
        assertThat(IOValidation.differentiateIGa('놀')).isEqualTo("이");
        assertThat(IOValidation.differentiateIGa('L')).isEqualTo("이");

    }
}