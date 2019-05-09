package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidationTest {
    @Test
    void filterTypoTest() {
        assertThat(InputValidation.filterTypos("asd, dgsad, sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(InputValidation.filterTypos("asd,     dgsad, sdf,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(InputValidation.filterTypos("asd,dgsad,sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(InputValidation.filterTypos("asd, dgsad, sdf,,,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
        assertThat(InputValidation.filterTypos("asd, dgsad,  sdf,,,,")).isEqualTo(Arrays.asList("asd","dgsad","sdf"));
    }

    @Test
    void areValidNamesTest() {
        assertThat(InputValidation.areValidNames(Arrays.asList("asd","dgsad","sdf"))).isTrue();
        assertThat(InputValidation.areValidNames(Arrays.asList("asd","dgsad","asd"))).isFalse();
        assertThat(InputValidation.areValidNames(Arrays.asList("asd"))).isFalse();
        assertThat(InputValidation.areValidNames(Arrays.asList("asd","dgsadsd","asd"))).isFalse();
    }

    @Test
    void isValidNumberTest() {
        assertThat(InputValidation.isValidNumber("7")).isTrue();
        assertThat(InputValidation.isValidNumber("761353431")).isTrue();
        assertThat(InputValidation.isValidNumber("-5")).isFalse();
        assertThat(InputValidation.isValidNumber("00009")).isTrue();
        assertThat(InputValidation.isValidNumber("HG")).isFalse();
    }
}