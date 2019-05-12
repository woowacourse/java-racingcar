package racing.domain;

import racing.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private List<RacingResult> racingResults = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    void addResult(RacingResult result) {
        racingResults.add(result);
    }

    public String searchWinners() {
        RacingResult lastRound = racingResults.get(racingResults.size() - 1);
        lastRound.compareTiePosition(winners);
        return getWinnersName();
    }

    private String getWinnersName() {
        return String.join(Helper.COMMA, winners);
    }

    public String makeAllResults() {
        StringBuilder sb = new StringBuilder();
        for (RacingResult result : racingResults) {
            sb.append(result.makeRoundResult());
        }
        return sb.toString();
    }
}
