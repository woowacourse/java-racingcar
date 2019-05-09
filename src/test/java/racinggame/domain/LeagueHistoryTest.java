package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueHistoryTest {
    private LeagueHistory leagueHistory;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        leagueHistory = new LeagueHistory();
        cars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("gogo"));
    }

    @Test
    void 기록을_제대로_하는지_테스트() {
        TrialHistory trialHistory = new TrialHistory(cars);
        leagueHistory.record(1, trialHistory);
        assertThat(leagueHistory.getHistoryOf(1)).isEqualTo(trialHistory);
    }

    @Test
    void 우승자를_제대로_선출하는지_테스트() {
        /* When */
        leagueHistory.record(1, new TrialHistory(cars));
        List<String> winners = leagueHistory.findWinners(1);
        /* Then */
        assertThat(winners.contains("pobi")).isTrue();
        assertThat(winners.contains("crong")).isTrue();
        assertThat(winners.contains("gogo")).isTrue();
    }
}