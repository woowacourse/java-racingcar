package racingcar.domain.input.racingtrytime.validator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.input.racingtrytime.validator.exception.NotNaturalNumberRacingTimeException;

class RacingTryTimeValidatorTest {
    private final RacingTryTimeValidator racingTryTimeValidator = new RacingTryTimeValidator();

    @DisplayName("입력받은 경주 시도 횟수는 자연수여야 한다.")
    @Test
    void racingTryTimeNaturalNumber() {
        String racingTryTime = "3";
        Assertions.assertThatCode(() -> racingTryTimeValidator.validate(racingTryTime))
            .doesNotThrowAnyException();
    }

    @DisplayName("입력받은 경주 시도 횟수가 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "-1", "0", "가", "aa"})
    void racingTryTimeNotNaturalNumberException(String racingTryTime) {
        Assertions.assertThatThrownBy(() -> racingTryTimeValidator.validate(racingTryTime))
            .isInstanceOf(NotNaturalNumberRacingTimeException.class);
    }
}