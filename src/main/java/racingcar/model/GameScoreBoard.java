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
}
