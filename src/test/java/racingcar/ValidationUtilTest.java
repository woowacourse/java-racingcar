package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ValidationUtilTest {
    @Test
    void 이름_길이가_6이상인_경우_예외발생() {
        String nameString = "pobi,jason11";

        assertThatThrownBy(() -> Validator.checkName(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이하");
    }

    @Test
    void 이름의_길이가_1보다_작은_경우_예외발생() {
        String nameString = "pobi,,jason";
        assertThatThrownBy(() -> Validator.checkName(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이상");
    }

    @Test
    void 빈문자열이_입력된_경우_예외발생() {
        String nameString = "";
        assertThatThrownBy(() -> Validator.checkInput(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이상");

    }

    @Test
    void 쉼표만_있는_경우_예외발생() {
        String nameString = ",,";

        assertThatThrownBy(() -> Validator.checkInput(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름을 입력해주세요");

    }

    @Test
    void 이름이_중복인_경우() {
        String nameString = "pobi,pobi";

        assertThatThrownBy(() -> Validator.checkInput(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 자동차_이름_수가_하나인_경우_예외발생() {
        String nameString = "pobi";

        assertThatThrownBy(() -> Validator.checkInput(nameString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("최소");
    }

    @Test
    void 횟수_입력값이_숫자가_아닌_경우() {
        String countString = "a";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자");
    }

    @Test
    void 횟수_입력값이_1미만인_경우() {
        String countString = "0";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    void 횟수_입력값이_50초과인_경우() {
        String countString = "51";

        assertThatThrownBy(() -> Validator.checkCount(countString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("50 이하");
    }
}
