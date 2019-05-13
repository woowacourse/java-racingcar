package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarInputInputValidatorTest {
    @Test
    void 게임_진행을_위한_자동차_개수가_기준치_미만일_때_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarInputValidator.checkAccuracyOfCarNames(new String[]{"car"});
        });
    }

    @Test
    void 중복된_자동차가_있을_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarInputValidator.checkAccuracyOfCarNames(new String[]{"car", "car"});
        });
    }

}