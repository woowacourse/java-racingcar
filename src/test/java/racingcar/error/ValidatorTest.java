package racingcar.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @Test
    void 입력이_Null_일_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkNull(null);
        });
    }

    @Test
    void 입력이_빈_칸일_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkBlank("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkBlank(" ");
        });
    }

    @Test
    void 게임_진행을_위한_자동차_개수가_기준치_미만일_때_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkAccuracyOfCarNames(new String[]{"car"});
        });
    }

    @Test
    void 중복된_자동차가_있을_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkAccuracyOfCarNames(new String[]{"car", "car"});
        });
    }

    @Test
    void 시행_횟수_입력에서_입력값이_숫자가_아닌_경우_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkAccuracyOfGameCount("e");
        });
    }
}