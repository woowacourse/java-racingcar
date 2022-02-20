package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<String> winners = new ArrayList<>();

    public RacingGame() {
    }

    public void addWinner(String name) {
        winners.add(name);
    }

    public List<String> getWinners() {
        return winners;
    }
}
