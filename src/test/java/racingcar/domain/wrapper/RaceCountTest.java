package racingcar.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.constant.RaceConstant.RACE_MIN_TRY_COUNT;
import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.TYPE_MESSAGE;

class RaceCountTest {


    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "10000"})
    @DisplayName("정상적인 시도 횟수가 들어오면 예외가 발생하지 않는다.")
    void givenNormalRaceCount_thenSuccess(final String raceCount) {
        assertThatCode(() -> RaceCount.create(raceCount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "23wooteco", "*@#$*"})
    @DisplayName("시도 횟수에 정수값이 들어오지 않을 경우 예외가 발생한다.")
    void givenNotNumberRaceCount_thenFail(final String raceCount) {
        assertThatThrownBy(() -> RaceCount.create(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("시도 횟수가 0 이하일 경우 예외가 발생한다.")
    void givenZeroRaceCount_thenFail(final String raceCount) {
        assertThatThrownBy(() -> RaceCount.create(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), RACE_MIN_TRY_COUNT.getValue()));
    }
}