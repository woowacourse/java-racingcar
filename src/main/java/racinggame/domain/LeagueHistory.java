package racinggame.domain;

import java.util.*;

public class LeagueHistory {
    private HashMap<Integer, TrialHistory> leagueHistory = new LinkedHashMap<>();

    public void record(int trial, TrialHistory trialHistory) {
        leagueHistory.put(trial, trialHistory);
    }

    public List<String> findWinnersOf(int trialNo) {
        TrialHistory lastTrialHistory = getHistoryOf(trialNo);

        return lastTrialHistory.findWinners();
    }

    public TrialHistory getHistoryOf(int trialNo) {
        return leagueHistory.get(trialNo);
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
