package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        /* Given */
        List<Car> cars = Arrays.asList(new Car("pobi"),
                new Car("crong", 3), new Car("gogo", 2));
        TrialHistory trialHistory = new TrialHistory(cars);

        /* When */
        leagueHistory.record(1, trialHistory);

        /* Then */
        assertThat(leagueHistory.getHistoryOf(1)).isEqualTo(trialHistory);
    }

    @Test
    void 우승자를_여러명_선출하는지_테스트() {
        /* Given */
        List<Car> cars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("gogo"));
        leagueHistory.record(1, new TrialHistory(cars));

        /* When */
        List<String> winners = leagueHistory.findWinnersOf(1);

        /* Then */
        assertThat(winners.contains("pobi")).isTrue();
        assertThat(winners.contains("crong")).isTrue();
        assertThat(winners.contains("gogo")).isTrue();
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    void 자동차가_움직인_뒤_제대로_우승자를_찾는지_테스트() {
        /* Given */
        List<Car> cars = Arrays.asList(new Car("pobi",2),
                new Car("crong",1), new Car("gogo",3));
        leagueHistory.record(1, new TrialHistory(cars));

        /* When */
        List<String> winners = leagueHistory.findWinnersOf(1);

        /* Then */
        assertThat(winners.contains("pobi")).isFalse();
        assertThat(winners.contains("crong")).isFalse();
        assertThat(winners.contains("gogo")).isTrue();
        assertThat(winners.size()).isEqualTo(1);
    }
}