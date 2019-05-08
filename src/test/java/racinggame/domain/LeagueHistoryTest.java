package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueHistoryTest {
    private LeagueHistory leagueHistory;

    @BeforeEach
    void setUp() {
        leagueHistory = new LeagueHistory();
    }

    @Test
    void 기록을_제대로_하는지_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("gogo"));
        TrialHistory trialHistory = new TrialHistory(cars);
        leagueHistory.record(1, trialHistory);
        assertThat(leagueHistory.getHistoryOf(1)).isEqualTo(trialHistory);
    }
}