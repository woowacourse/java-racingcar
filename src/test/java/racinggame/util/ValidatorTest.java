package racinggame.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void 이름을_유효성검사에서_예외를_제대로_던지는지_테스트() {
        /* Given */
        final List<String> duplicatedCarNames = Arrays.asList("crong", "crong", "gogo");
        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkDuplicateNames(duplicatedCarNames);
        });
    }

    @Test
    void 시도횟수_유효성검사에서_예외를_제대로_던지는지_테스트() {
        /* Given */
        final int negativeNumber = -1;
        final int zero = 0;
        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkPositiveNumber(negativeNumber);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkPositiveNumber(zero);
        });
    }
}