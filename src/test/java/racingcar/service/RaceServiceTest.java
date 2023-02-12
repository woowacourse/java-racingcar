package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.dto.RaceResultDto;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    private Cars testCars;

    private RaceService raceService;

    @BeforeEach
    void init() {
        CarsService carsService = new CarsService();
        raceService = new RaceService(carsService);
        String testCarNames = "pobi,crong,honux";
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @Test
    @DisplayName("경주를 진행하면 사용자가 입력한 시도 횟수만큼 전체 결과를 생성하고, 자동차의 개수만큼 경주 결과를 생성한다.")
    void givenRaceCount_whenStart_thenReturnResultAboutRaceCount() {
        // given
        String raceCount = "2";
        Race testRace = TestProvider.createTestRace(raceCount);
        int carCount = testCars.getCars().size();

        // when
        List<RaceResultDto> raceResults = raceService.getRaceResults(testCars, testRace);
        int normalCarRaceResultCount = (int) raceResults.stream()
                .filter(raceResult -> raceResult.getCarRaceResult().size() == carCount)
                .count();

        // then
        assertThat(raceResults.size())
                .isEqualTo(Integer.parseInt(raceCount));

        assertThat(normalCarRaceResultCount)
                .isEqualTo(Integer.parseInt(raceCount));
    }
}