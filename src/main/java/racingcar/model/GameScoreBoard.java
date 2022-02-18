package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameScoreBoard {
    private final List<ScoreBoard> scoreBoards = new ArrayList<>();

    public void add(ScoreBoard scoreBoard) {
        scoreBoards.add(scoreBoard);
    }

    public List<ScoreBoard> getScoreBoards() {
        return scoreBoards;
    }

    public List<String> findWinners() {
        return scoreBoards.get(getSize() - 1).findWinners();
    }

    private int getSize() {
        return scoreBoards.size();
    }
}
