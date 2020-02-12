package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.InputValidation;
import racingcar.View.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RacingCarTest {

    @Test
    @DisplayName("컴마로 분리")
    void inputControl_컴마로_분리() {
        String[] result = InputView.inputCarName("포드,페라리,마세라티");
        assertThat(result).containsExactly("포드", "페라리", "마세라티");
    }

    @Test
    @DisplayName("null 또는 빈 문자열 입력 시")
    void inputControl_null_또는_빈문자열_입력() {
        String nullResult = null;
        String emptyResult = "";

        assertThatThrownBy(() -> {
            InputValidation.checkNullOrEmptyInput(nullResult);
        }).isInstanceOf(NullPointerException.class)
        .hasMessage("입력이 null 이나 빈 문자열입니다.");

        assertThatThrownBy( () -> {
            InputValidation.checkNullOrEmptyInput(emptyResult);
        }).isInstanceOf(NullPointerException.class)
        .hasMessage("입력이 null 이나 빈 문자열입니다.");
    }

    @Test
    @DisplayName("차 이름이 5글자 이내")
    void inputControl_차_이름_글자수() {
        assertThatThrownBy(() -> {
            String result = "Maserati";
            InputValidation.checkSmallerThanSix(result);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름의 길이가 6 이상입니다.");
    }

    @Test
    @DisplayName("시도횟수가 음수 또는 0")
    void inputControl_시도횟수가_0이하() {
        assertThatThrownBy(() -> {
            String trialTime  = "-4";
            InputValidation.checkNegativeAndZeroInput(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 또는 0을 입력할 수 없습니다.");

        assertThatThrownBy(() -> {
            String trialTime  = "0";
            InputValidation.checkNegativeAndZeroInput(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 또는 0을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 타입 범위를 초과할 경우")
    void inputControl_시도횟수가_타입_범위초과() {
        assertThatThrownBy(() -> {
            String trialTime = "100000000000";
            InputValidation.checkIntegerOverflow(trialTime);
        });
    }
}
