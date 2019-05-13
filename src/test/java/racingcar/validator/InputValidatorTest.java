package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {
    @Test
    void 입력이_Null_일_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkNull(null);
        });
    }

    @Test
    void 입력이_빈_칸일_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkBlank("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkBlank(" ");
        });
    }
}