package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final String STICK = "-";
    public static final String CAR_RESULT = "%s : %s\n";

    public static final int CAR_MOVE_DISTANCE = 1;

    private LinkedHashMap<MovableStrategy, Integer> scoreBoard;
    private int winnerScore;

    public Racing(LinkedHashMap<MovableStrategy, Integer> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void moveAll() {
        scoreBoard.keySet()
                .stream()
                .filter(MovableStrategy::isMove)
                .forEach(this::updateScoreBoard);
    }

    public List<MovableStrategy> getWinner() {
        return scoreBoard.keySet()
                .stream()
                .filter(car -> scoreBoard.get(car) == winnerScore)
                .collect(Collectors.toList());
    }

    private void updateScoreBoard(MovableStrategy key) {
        int score = scoreBoard.get(key) + CAR_MOVE_DISTANCE;
        winnerScore = Math.max(winnerScore, score);
        scoreBoard.put(key, score);
    }

    @Override
    public String toString() {
        return scoreBoard.keySet()
                .stream()
                .map(this::convertResultToString)
                .collect(Collectors.joining());
    }

    private String convertResultToString(MovableStrategy car) {
        return String.format(CAR_RESULT, car.toString(), STICK.repeat(scoreBoard.get(car)));
    }
}
