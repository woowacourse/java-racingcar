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
        final List<Car> cars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("gogo"));
        final TrialHistory trialHistory = new TrialHistory(cars);

        /* When */
        leagueHistory.record(1, trialHistory);
        assertThat(leagueHistory.getHistoryOf(1)).isEqualTo(trialHistory);
    }

    @Test
    void 우승자를_여러명_선출하는지_테스트() {
        /* Given */
        final List<Car> cars = Arrays.asList(new Car("pobi"),
                new Car("crong"), new Car("gogo"));
        leagueHistory.record(1, new TrialHistory(cars));

        /* When */
        final List<String> winners = leagueHistory.findWinners(1);

        /* Then */
        assertThat(winners.contains("pobi")).isTrue();
        assertThat(winners.contains("crong")).isTrue();
        assertThat(winners.contains("gogo")).isTrue();
    }

    @Test
    void 자동차가_움직인_뒤_제대로_우승자가_나오는지_테스트() {
        /* Given */
        final List<Car> cars = Arrays.asList(new Car("pobi",2),
                new Car("crong",1), new Car("gogo",3));
        leagueHistory.record(1, new TrialHistory(cars));

        /* When */
        final List<String> winners = leagueHistory.findWinners(1);

        /* Then */
        assertThat(winners.contains("pobi")).isFalse();
        assertThat(winners.contains("crong")).isFalse();
        assertThat(winners.contains("gogo")).isTrue();
    }
}