package racingcar.input.utils.racingtrytime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingTryTimeValidatorUtilsTest {

    @DisplayName("경주 시도 횟수가 자연수이면 정상")
    @Test
    void validNaturalNumberRacingTryTime() {
        String racingTryTime = "2";
        assertDoesNotThrow(() -> RacingTryTimeValidatorUtils.isVaildNaturalNumber(racingTryTime));
    }

    @DisplayName("경주 시도 횟수가 자연수가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "가", "0", "-1", "1.12"})
    void notNaturalNumberRacingTryTimeException(String racingTryTimeInput) {
        assertThrows(InvalidNotNaturalNumberRacingTryTimeException.class,
            () -> RacingTryTimeValidatorUtils.isVaildNaturalNumber(racingTryTimeInput));
    }
}
