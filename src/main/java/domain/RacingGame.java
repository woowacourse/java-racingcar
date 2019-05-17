package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int leftTrials;

    public RacingGame(int numTrials) {
        this.leftTrials = numTrials;
    }

    public List<Car> playTrial(List<Car> cars) {
        if (leftTrials == 0) {
            return new ArrayList<>();
        }
        leftTrials--;

        return cars.stream().map(car -> car.move()).collect(Collectors.toList());
    }

    public boolean isFinished() {
        return leftTrials == 0;
    }
}
