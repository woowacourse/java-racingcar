package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.dto.RaceResultDto;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.constant.RaceConstant.RACE_MIN_TRY_COUNT;
import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.TYPE_MESSAGE;
import static racingcar.provider.TestProvider.createTestCars;
import static racingcar.provider.TestProvider.createTestRace;

public class RaceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "10000"})
    @DisplayName("정상적인 시도 횟수가 들어오면 예외가 발생하지 않는다.")
    void givenNormalRaceCount_thenSuccess(String raceCount) {
        assertThatCode(() -> createTestRace(raceCount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "23wooteco", "*@#$*"})
    @DisplayName("시도 횟수에 정수값이 들어오지 않을 경우 예외가 발생한다.")
    void givenNotNumberRaceCount_thenFail(String raceCount) {
        assertThatThrownBy(() -> createTestRace(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("시도 횟수가 0 이하일 경우 예외가 발생한다.")
    void givenZeroRaceCount_thenFail(String raceCount) {
        assertThatThrownBy(() -> createTestRace(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), RACE_MIN_TRY_COUNT.getValue()));
    }

    @Test
    @DisplayName("사용자가 입력한 시도 횟수만큼 결과를 생성한다.")
    void givenRaceCount_whenStart_thenReturnResultAboutRaceCount() {
        // given
        String carNames = "pobi,crong,honux";
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(false);
        Cars testCars = createTestCars(carNames, numberGenerator);

        String raceCount = "3";
        Race testRace = createTestRace(raceCount);

        // when
        List<RaceResultDto> raceResult = testRace.getRaceResult(testCars);

        // then
        assertThat(raceResult.size())
                .isEqualTo(Integer.parseInt(raceCount));
    }
}
