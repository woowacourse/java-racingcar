package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(String inputCars, String inputRound) {
        this.cars = new Cars(inputCars);
        this.round = new Round(inputRound);
    }

    public void playRound(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
    }

    public List<Car> getRoundResult() {
        return Collections.unmodifiableList(cars.getCars());
    }
}
