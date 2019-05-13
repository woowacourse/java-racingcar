package racinggame.domain;

import java.util.*;

public class LeagueHistory {
    private Map<Integer, TrialHistory> leagueHistory = new LinkedHashMap<>();

    public void record(final int trial, final TrialHistory trialHistory) {
        leagueHistory.put(trial, trialHistory);
    }

    public List<String> findWinners(final int lastRound) {
        TrialHistory lastTrialHistory = getHistoryOf(lastRound);

        return lastTrialHistory.findWinners();
    }

    public TrialHistory getHistoryOf(final int trial) {
        return leagueHistory.get(trial);
    }

    public Collection<TrialHistory> values() {
        return leagueHistory.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueHistory that = (LeagueHistory) o;
        return Objects.equals(leagueHistory, that.leagueHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueHistory);
    }
}
