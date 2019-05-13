package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCountInputInputValidatorTest {
    @Test
    void 시행_횟수_입력에서_입력값이_숫자가_아닌_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameCountInputValidator.checkAccuracyOfGameCount("e");
        });
    }
}