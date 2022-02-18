package racingcar.model;

import java.util.List;

public class ScoreBoard {
    private final int round;
    private final List<Score> scores;

    public ScoreBoard(int round, List<Score> scores) {
        this.round = round;
        this.scores = scores;
    }

    public int getRound() {
        return round;
    }

    public List<Score> getScores() {
        return scores;
    }
}
