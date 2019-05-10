package racinggame.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LeagueHistory {
    private HashMap<Integer, TrialHistory> leagueHistory = new LinkedHashMap<>();

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
}
