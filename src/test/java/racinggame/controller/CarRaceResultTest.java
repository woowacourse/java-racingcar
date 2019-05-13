package racinggame.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.LeagueHistory;
import racinggame.domain.TrialHistory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceResultTest {
    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        List<Car> cars = Arrays.asList(new Car("pobi", 2), new Car("crong", 2));
        carRacing = new CarRacing(cars, 1);
    }

    @Test
    void 객체가_제대로_생성되는지_테스트() {
        /* Given */
        LeagueHistory leagueHistory = new LeagueHistory();

        /* Then */
        assertThat(new CarRaceResult(leagueHistory, 3))
                .isEqualTo(new CarRaceResult(leagueHistory, 3));
    }

    @Test
    void CarRaceResult가_제대로_승자를_가져오는지_테스트() {
        /* When */
        CarRaceResult raceResult = carRacing.raceStart(new CarAlwaysRun());

        /* Then */
        assertThat(raceResult.getRaceWinners()).isEqualTo(Arrays.asList("pobi", "crong"));
    }

    @Test
    void CarRaceResult에_제대로_기록을_가져오는지_테스트() {
        /* When */
        CarRaceResult raceResult = carRacing.raceStart(new CarAlwaysRun());

        /* Then */
        assertThat(raceResult.getRaceResult().contains(new TrialHistory(Arrays.asList(
                new Car("pobi", 3), new Car("crong", 3))))).isTrue();
        assertThat(raceResult.getRaceResult().contains(new TrialHistory(Arrays.asList(
                new Car("pobi", 4), new Car("crong", 4))))).isFalse();
    }
}