package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.InputValidation;
import racingcar.View.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @Test
    @DisplayName("컴마로 분리")
    void inputControl_컴마로_분리() {
        String[] result = InputView.inputCarName("포드,페라리,마세라티");
        assertThat(result).containsExactly("포드", "페라리", "마세라티");
    }

    @Test
    @DisplayName("차 이름이 5글자 이내")
    void inputControl_차_이름_글자수() {
        String result = "Maserati";
        assertFalse(InputValidation.isSmallerThanSix(result));
        result = "Ford";
        assertTrue(InputValidation.isSmallerThanSix(result));
    }
}
