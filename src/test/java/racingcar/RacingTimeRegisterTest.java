package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidRacingTimeException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTimeRegisterTest {

    private final RacingTimeRegister racingTimeRegister = new RacingTimeRegister();

    @DisplayName("경주 시도 횟수 자연수 검사")
    @Test
    void registerRacingTime() {
        String inputRacingTime = "2";
        Assertions
                .assertThat(racingTimeRegister.registerRacingTime(inputRacingTime))
                .isEqualTo(2);
    }

    @DisplayName("경주 시도 횟수 자연수 검사 - 음수 예외")
    @Test
    void validateRacingTimeZeroOrLess() {
        String inputRacingTime = "0";
        assertThatThrownBy(() -> racingTimeRegister.registerRacingTime(inputRacingTime))
                .isInstanceOf(InvalidRacingTimeException.class);
    }

    @DisplayName("경주 시도 횟수 자연수 검사 - 문자 예외")
    @Test
    void validateRacingTimeType() {
        String inputRacingTime = "a";
        assertThatThrownBy(() -> racingTimeRegister.registerRacingTime(inputRacingTime))
                .isInstanceOf(InvalidRacingTimeException.class);
    }
}
