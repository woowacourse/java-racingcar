package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.provider.TestProvider.createTestCars;
import static racingcar.provider.TestProvider.createTestWinnerCar;

class WinnerCarTest {

    private String testCarNames;

    @BeforeEach
    void init() {
        testCarNames = "pobi,crong,honux";
    }

    @Test
    @DisplayName("우승한 자동차 이름을 뽑는다.")
    void givenWinnerCar_thenPickWinnerCarName() {
        // given
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(true);
        Cars testCars = createTestCars(testCarNames, numberGenerator);
        testCars.race();
        WinnerCar winnerCar = createTestWinnerCar(testCars);

        // when
        List<String> winners = winnerCar.getName();

        // then
        assertThat(winners.size())
                .isEqualTo(1);

        assertThat(winners)
                .isEqualTo(List.of("honux"));
    }

    @Test
    @DisplayName("우승한 자동차 이름 리스트를 뽑는다.")
    void givenWinnerCar_thenPickWinnerCarNames() {
        // given
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(false);
        Cars testCars = createTestCars(testCarNames, numberGenerator);
        testCars.race();
        WinnerCar winnerCar = createTestWinnerCar(testCars);

        // when
        List<String> winners = winnerCar.getName();

        // then
        assertThat(winners)
                .isEqualTo(List.of("pobi", "crong", "honux"));
    }
}