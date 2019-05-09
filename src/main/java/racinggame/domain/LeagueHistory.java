package racinggame.domain;

import java.util.*;

public class LeagueHistory {
    private HashMap<Integer, TrialHistory> leagueHistory = new LinkedHashMap<>();

    public void record(int trial, TrialHistory trialHistory) {
        leagueHistory.put(trial, trialHistory);
    }

    public void showHistory() {

    }


    public TrialHistory getHistoryOf(int trial) {
        return leagueHistory.get(trial);
    }

    public List<String> findWinners(int lastRound) {
        TrialHistory lastTrialHistory = getHistoryOf(lastRound);

        return lastTrialHistory.findWinners();
    }
}
