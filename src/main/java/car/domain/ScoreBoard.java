package car.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;

public final class ScoreBoard {
    
    private final List<Score> scores;
    
    private ScoreBoard(List<Score> scores) {
        this.scores = scores;
    }
    
    public static ScoreBoard record(List<Car> racingCars) {
        List<Score> scores = new ArrayList<>();
        
        for (Car racingCar : racingCars) {
            scores.add(racingCar.getScore());
        }
        
        return new ScoreBoard(scores);
    }
    
    public List<Score> getScores() {
        return Collections.unmodifiableList(scores);
    }
    
    public List<String> findWinners() {
        return getWinners(retrieveMaxPosition());
    }
    
    private List<String> getWinners(int maxPosition) {
        return scores.stream()
                     .collect(groupingBy(Score::getPosition, mapping(Score::getName, toList())))
                     .get(maxPosition);
    }
    
    private int retrieveMaxPosition() {
        return scores.stream()
                     .max(Score::compareTo)
                     .orElseThrow(IllegalArgumentException::new)
                     .getPosition();
    }
}
