package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.LeagueHistory;
import racinggame.domain.NumberGenerator;

public class League {
    private int totalTrial;

    public League(int totalTrial) {
        this.totalTrial = totalTrial;
    }

    public LeagueHistory startRace(Cars cars, NumberGenerator numberGenerator) {
        LeagueHistory leagueHistory = new LeagueHistory();

        for (int trial = 1; trial <= totalTrial; trial++) {
            cars.moveBy(numberGenerator);
            leagueHistory.record(trial, cars.makeTrialHistory());
        }
        return leagueHistory;
    }
}
