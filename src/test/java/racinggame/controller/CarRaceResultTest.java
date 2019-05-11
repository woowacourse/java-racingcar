package racinggame.controller;

import org.junit.jupiter.api.Test;
import racinggame.domain.LeagueHistory;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceResultTest {
    @Test
    void 객체가_제대로_생성되는지_테스트() {
        /* Given */
        LeagueHistory leagueHistory = new LeagueHistory();
        /* Then */
        assertThat(new CarRaceResult(leagueHistory)).isEqualTo(new CarRaceResult(leagueHistory));
    }
}