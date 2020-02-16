package racingcargame.domain.result;

import java.util.List;

public class CarRaceResult {

    public static final int ROUND_INDEX_DIFFERENCE = 1;
    private final List<RoundResult> roundResultList;

    public CarRaceResult(List<RoundResult> roundResultList) {
        this.roundResultList = roundResultList;
    }

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public List<String> getWinners() {
        RoundResult lastRoundResult = roundResultList.get(getLastIndex());
        return lastRoundResult.getWinners();
    }

    private int getLastIndex() {
        return roundResultList.size() - ROUND_INDEX_DIFFERENCE;
    }
}
