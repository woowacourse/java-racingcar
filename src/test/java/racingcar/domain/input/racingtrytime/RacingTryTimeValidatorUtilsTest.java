package racingcar.domain.input.racingtrytime;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.input.racingtrytime.validator.RacingTryTimeValidatorUtils;
import racingcar.domain.input.racingtrytime.validator.exception.NotNaturalNumberRacingTimeException;

public class RacingTryTimeValidatorUtilsTest {

    @DisplayName("경주 시도 횟수가 자연수이면 정상")
    @Test
    void validNaturalNumberRacingTryTime() {
        String racingTryTime = "2";
        assertThatCode(
            () -> RacingTryTimeValidatorUtils.validateNaturalNumberRacingTime(racingTryTime))
            .doesNotThrowAnyException();
    }

    @DisplayName("경주 시도 횟수가 자연수가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "가", "0", "-1", "1.12"})
    void notNaturalNumberRacingTryTimeException(String racingTryTimeInput) {
        assertThatThrownBy(
            () -> RacingTryTimeValidatorUtils.validateNaturalNumberRacingTime(racingTryTimeInput))
            .isInstanceOf(NotNaturalNumberRacingTimeException.class);
    }
}
