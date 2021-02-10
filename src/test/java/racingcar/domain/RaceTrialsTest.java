package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidTimeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTrialsTest {

    @DisplayName("시도 횟수가 자연수가 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "0", ""})
    public void inputInvalidTrials(String input) {
        assertThatThrownBy(() -> new RaceTrials(input))
                .isInstanceOf(InvalidTimeException.class);
    }

}