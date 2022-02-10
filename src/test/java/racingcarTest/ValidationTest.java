package racingcarTest;

import addCalculatorTest.StringCalculator;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputController;
import racingcar.controller.MainController;
import racingcar.controller.Validation;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void 플레이어_이름_5자_초과_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation("aaaaaaa,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_이름_0자_검증() {
        assertThatThrownBy(() -> Validation.carNameValidation(",,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_회수_입력_검증_1() {
        assertThatThrownBy(() -> Validation.tryNumValidation("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_회수_입력_검증_2() {
        assertThatThrownBy(() -> Validation.tryNumValidation("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_회수_입력_검증_3() {
        Validation.tryNumValidation("5");
    }
}
