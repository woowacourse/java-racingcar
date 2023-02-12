package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class GameResultResponse {
    private final List<String> winnerNames = new ArrayList<>();

    public GameResultResponse(List<String> winnerNames) {
        this.winnerNames.addAll(winnerNames);
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
