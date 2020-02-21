package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameLog {
    List<EachRaceResult> gameLog = new ArrayList<>();

    public List<EachRaceResult> getGameLog() {
        return gameLog;
    }

    void putGameResult(EachRaceResult eachRaceResult) {
        gameLog.add(eachRaceResult);
    }
}
