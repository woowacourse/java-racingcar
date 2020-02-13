package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.InputValidation;
import racingcar.View.InputView;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputControlTest {
    @Test
    @DisplayName("null 또는 빈 문자열 입력 시")
    void inputControl_null_또는_빈문자열_입력() {
        String[] nullResult = null;
        String[] emptyResult = {""};

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
    @DisplayName("차 이름에 빈 문자열 입력 시")
    void checkEmptyCarName() {
        String[] carNames = {"a", "", "c"};
        assertThatThrownBy(() -> {
            InputValidation.checkEmptyCarName(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 빈 문자열일 수 없습니다.");

    }

    @Test
    @DisplayName("차 이름이 5글자 이내")
    void inputControl_차_이름_글자수() {
        assertThatThrownBy(() -> {
            String[] result = {"Maserati"};
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
        }).isInstanceOf(ArithmeticException.class)
        .hasMessage("입력 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 소수인 경우")
    void inputControl_시도횟수가_소수_입력() {
        assertThatThrownBy(() -> {
            String trialTime = "3.5";
            InputValidation.checkDecimalNumber(trialTime);
        }).isInstanceOf(InputMismatchException.class)
        .hasMessage("소수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 문자인 경우")
    void inputControl_시도횟수가_문자_입력() {
        assertThatThrownBy(() -> {
            String trialTime = "abc";
            InputValidation.checkNotNumber(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("문자는 입력할 수 없습니다.");
    }
}
