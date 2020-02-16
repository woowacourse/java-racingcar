package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Name;
import racingcar.Model.TrialTime;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 클래스 이름 : inputValidationTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class InputValidationTest {
    @Test
    @DisplayName("차 이름에 빈 문자열 입력 시")
    void inputValidation_차_이름_빈_문자열() {
        String carNames = "";
        assertThatThrownBy(() -> {
            Name.checkEmptyCarName(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 빈 문자열일 수 없습니다.");

    }

    @Test
    @DisplayName("차 이름이 5글자 이내")
    void inputValidation_차_이름_글자수() {
        assertThatThrownBy(() -> {
            String result = "Maserati";
            Name.checkSmallerThanSix(result);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름의 길이가 6 이상입니다.");
    }

    @Test
    @DisplayName("시도횟수가 음수 또는 0")
    void inputValidation_시도횟수가_0이하() {
        assertThatThrownBy(() -> {
            String trialTime = "-4";
            TrialTime.checkNegativeAndZeroInput(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 또는 0을 입력할 수 없습니다.");

        assertThatThrownBy(() -> {
            String trialTime = "0";
            TrialTime.checkNegativeAndZeroInput(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 또는 0을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 타입 범위를 초과할 경우")
    void inputValidation_시도횟수가_타입_범위초과() {
        assertThatThrownBy(() -> {
            String trialTime = "100000000000";
            TrialTime.checkIntegerOverflow(trialTime);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessage("입력 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 소수인 경우")
    void inputValidation_시도횟수가_소수_입력() {
        assertThatThrownBy(() -> {
            String trialTime = "3.5";
            TrialTime.checkDecimalNumber(trialTime);
        }).isInstanceOf(InputMismatchException.class)
                .hasMessage("소수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 문자인 경우")
    void inputValidation_시도횟수가_문자_입력() {
        assertThatThrownBy(() -> {
            String trialTime = "abc";
            TrialTime.checkNotNumber(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자는 입력할 수 없습니다.");
    }
}
