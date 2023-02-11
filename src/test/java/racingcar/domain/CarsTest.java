package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.dto.CarRaceDto;
import racingcar.exception.DuplicateException;
import racingcar.exception.GlobalException;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;

class CarsTest {

    private Cars testCars;

    private String testCarNames;

    private MockNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        testCarNames = "pobi,crong,honux";
        numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("정상적인 자동차 이름이 들어오면 예외가 발생하지 않는다.")
    void givenNormalCarNames_thenSuccess(String carNames) {
        // when & then
        assertThatCode(() -> Cars.of(carNames, numberGenerator))
                .doesNotThrowAnyException();

        assertThat(Cars.of(carNames, numberGenerator))
                .isEqualTo(testCars);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("자동차 이름에 null 값이 들어오면 split 시 에외가 발생한다.")
    void givenNullCarNames_thenFail(String carNames) {
        assertThatThrownBy(() -> Cars.of(carNames, numberGenerator))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "pobi, pobi"})
    @DisplayName("자동차 이름에 중복값이 들어오면 예외가 발생한다.")
    void givenDuplicateCarNames_thenFail(String carNames) {
        assertThatThrownBy(() -> Cars.of(carNames, numberGenerator))
                .isInstanceOf(GlobalException.class)
                .isExactlyInstanceOf(DuplicateException.class)
                .hasMessageContaining(DUPLICATE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("모든 자동차의 초기 위치는 1이어야 한다.")
    void givenCars_whenInit_thenPositionIsOne() {
        // when
        List<CarRaceDto> initResult = testCars.initStatus();

        // then
        int normalPositionCarCount = (int) initResult.stream()
                .filter(carRaceDto -> carRaceDto.getCarPosition() == 1)
                .count();

        assertThat(normalPositionCarCount)
                .isEqualTo(3);
    }

    @Test
    @DisplayName("경주를 진행하면 자동차의 개수만큼 결과가 나와야 한다.")
    void givenCars_whenRace_thenReturnResultAboutCarCount() {
        // when
        List<CarRaceDto> carRaceResult = testCars.race();

        // then
        assertThat(carRaceResult.size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("우승한 자동차를 뽑는다.")
    void givenCarInfo_thenPickWinner() {
        // given
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(true);
        Cars testCars = TestProvider.createTestCars(testCarNames, numberGenerator);

        // when
        testCars.race();
        List<String> winners = testCars.pickWinners();

        // then
        assertThat(winners.size())
                .isEqualTo(1);

        assertThat(winners)
                .isEqualTo(List.of("honux"));
    }

    @Test
    @DisplayName("우승한 자동차 리스트를 뽑는다.")
    void givenCarInfo_thenPickWinners() {
        // when
        testCars.race();
        List<String> winners = testCars.pickWinners();

        // then
        assertThat(winners)
                .isEqualTo(List.of("pobi", "crong", "honux"));
    }
}