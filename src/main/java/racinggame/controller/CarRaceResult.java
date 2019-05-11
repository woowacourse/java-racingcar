package racinggame.controller;

import racinggame.domain.LeagueHistory;
import racinggame.util.OutputView;

import java.util.Objects;

public class CarRaceResult {
    private final LeagueHistory leagueHistory;

    public CarRaceResult(final LeagueHistory leagueHistory) {
        this.leagueHistory = leagueHistory;
    }

    public void showCarRaceResult(final int lastTrial) {
        OutputView.showHistory(leagueHistory);
        OutputView.showWinners(leagueHistory.findWinners(lastTrial));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRaceResult that = (CarRaceResult) o;
        return Objects.equals(leagueHistory, that.leagueHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueHistory);
    }
}
