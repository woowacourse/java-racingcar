package racinggame.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LeagueHistory {
    private HashMap<Integer, TrialHistory> leagueHistory = new LinkedHashMap<>();

    public void record(int trial, TrialHistory trialHistory) {
        leagueHistory.put(trial, trialHistory);
    }

    public void showHistory() {
        System.out.println("실행 결과");
        for (TrialHistory trialHistory : leagueHistory.values()) {
            trialHistory.showTrialResult();
            System.out.println("");
        }
    }

    public TrialHistory getHistoryOf(int trial) {
        return leagueHistory.get(trial);
    }

    public List<String> findWinners(int lastRound) {
        TrialHistory lastTrialHistory = getHistoryOf(lastRound);

        return lastTrialHistory.findWinners();
    }
}
