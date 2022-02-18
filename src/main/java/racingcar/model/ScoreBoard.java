package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> findWinners() {
        int maxPoint = findMaxScore();
        return scores.stream()
                .filter(i -> i.matchScore(maxPoint))
                .map(Score::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int findMaxScore() {
        return scores.stream()
                .max(Score::compareTo)
                .map(Score::getPoint)
                .orElseThrow(RuntimeException::new);
    }
}
