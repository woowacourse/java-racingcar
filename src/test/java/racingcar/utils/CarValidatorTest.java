package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarValidatorTest {

    @Test
    public void 정상적인_자동차_이름_입력() {
        String userInput = "pobi,cony,whale";
        assertThatCode(() -> CarValidator.checkCarNames(userInput)).doesNotThrowAnyException();
    }

    @Test
    public void 비정상적인_자동차_이름_입력() {
        String userInput1 = "pobi,  ,whale"; // 예외가 발생해야 한다
        String userInput2 = "        ";
        String userInput3 = ",,,,";
        assertThatThrownBy(() -> CarValidator.checkCarNames(userInput1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarValidator.checkCarNames(userInput2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarValidator.checkCarNames(userInput3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상적인_게임_횟수_입력() {
        assertThatCode(() -> CarValidator.checkNumberOfGame(100)).doesNotThrowAnyException();
    }

    @Test
    public void 비정상적인_게임_횟수_입력() {
        assertThatThrownBy(() -> CarValidator.checkNumberOfGame(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarValidator.checkNumberOfGame(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
