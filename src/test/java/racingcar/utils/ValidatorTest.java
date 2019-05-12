package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 자동차_이름_입력시_예외가_제대로_발생하는지_확인한다() {
        String userInput1 = "pobi,cony,whale"; // 예외가 발생하지 않아야 한다
        String userInput2 = "pobi,  ,whale"; // 예외가 발생해야 한다
        String userInput3 = "        ";
        String userInput4 = ",,,,";

        assertThatCode(() -> Validator.checkCarNames(userInput1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> Validator.checkCarNames(userInput2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkCarNames(userInput3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkCarNames(userInput4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수_입력시_예외가_제대로_발생하는지_확인한다() {
        assertThatCode(() -> Validator.checkNumberOfGame(100)).doesNotThrowAnyException();
        assertThatThrownBy(() -> Validator.checkNumberOfGame(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.checkNumberOfGame(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
