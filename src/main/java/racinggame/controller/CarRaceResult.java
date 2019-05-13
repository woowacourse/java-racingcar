package racinggame.controller;

import racinggame.domain.LeagueHistory;
import racinggame.domain.TrialHistory;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CarRaceResult {
    private final LeagueHistory leagueHistory;
    private final int lastTrial;

    public CarRaceResult(final LeagueHistory leagueHistory, final int lastTrial) {
        this.leagueHistory = leagueHistory;
        this.lastTrial = lastTrial;
    }

    public Collection<TrialHistory> getRaceResult() {
        return leagueHistory.values();
    }

    public List<String> getRaceWinners() {
        return leagueHistory.findWinners(lastTrial);
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
