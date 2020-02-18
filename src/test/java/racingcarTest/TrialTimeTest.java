package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.TrialTime;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialTimeTest {
    @ParameterizedTest
    @CsvSource(value = {"-4", "0"})
    @DisplayName("시도횟수가 음수 또는 0")
    void inputValidation_시도횟수가_0이하(String trialTime) {
        assertThatThrownBy(() -> {
            TrialTime.checkNegativeAndZeroInput(trialTime);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 또는 0을 입력할 수 없습니다.");

        assertThatThrownBy(() -> {
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
