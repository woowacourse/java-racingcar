package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.LeagueHistory;

public class League {
    private int totalTrial;

    public League(int totalTrial) {
        this.totalTrial = totalTrial;
    }

    public LeagueHistory startRaceOf(Cars cars) {
        LeagueHistory leagueHistory = new LeagueHistory();

        for (int trial = 1; trial <= totalTrial; trial++) {
            cars.randomMove();
            leagueHistory.record(trial, cars.makeTrialHistory());
        }
        return leagueHistory;
    }
}
