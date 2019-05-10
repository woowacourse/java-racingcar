package racinggame.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
}
