package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTimeRegisterTest {

    @DisplayName("경주 시도 횟수 자연수 검사")
    @Test
    void registerRacingTime() {
        String inputRacingTime = "2";
        Assertions
                .assertThat(RacingTimeRegister.registerRacingTime(inputRacingTime))
                .isEqualTo(inputRacingTime);
    }

    @DisplayName("경주 시도 횟수 자연수 검사 - 음수 예외")
    @Test
    void registerRacingTimeMinusException() {
        String inputRacingTime = "-1";
        assertThatThrownBy(() -> RacingTimeRegister.registerRacingTime(inputRacingTime))
                .isInstanceOf(InvalidRacingTimeException.class);
    }

    @DisplayName("경주 시도 횟수 자연수 검사 - 문자 예외")
    @Test
    void registerRacingTimeNotNumbersException() {
        String inputRacingTime = "a";
        assertThatThrownBy(() -> RacingTimeRegister.registerRacingTime(inputRacingTime))
                .isInstanceOf(InvalidRacingTimeException.class);
    }
}
