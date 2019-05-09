package racingcar.error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {

    @Test
    void 자동차_개수가_2개이상인지_검사하는_동작이_작동하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Validator.checkAccuracyOfCarNames(new String[]{"car"});
        });
    }

    @Test
    void 중복된_차를_검사하는_동작이_작동하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Validator.checkAccuracyOfCarNames(new String[]{"car", "car"});
        });
    }
}