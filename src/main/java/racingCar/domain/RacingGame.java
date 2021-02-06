package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.Engine.Engine;
import racingCar.domain.Engine.RandomEngine;
import racingCar.exception.NoWinnerException;

public class RacingGame {

    public static final String ERROR_MESSAGE_NO_WINNER = "우승자가 존재하지 않습니다.";
    public static final String DELIMITER = ",";
    private final List<Car> cars;
    private int numOfRacingRound;

    public RacingGame(String[] carNames, int numOfRacingRound) {
        this.cars = prepareCars(carNames);
        this.numOfRacingRound = numOfRacingRound;
    }

    private List<Car> prepareCars(String[] carNames) {
        Engine engine = new RandomEngine();
        return Arrays.stream(carNames)
            .map(carName -> new Car(carName, engine))
            .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return numOfRacingRound == 0;
    }

    public void race() {
        racePerRound();
        numOfRacingRound--;
    }

    private void racePerRound() {
        cars.forEach(Car::run);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinners() {
        int max = findMaxMove();
        return cars.stream()
            .filter(car -> car.isOn(max))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    private int findMaxMove() {
        List<Integer> traces = cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
        return traces.stream()
            .max(Integer::compare)
            .orElseThrow(() -> new NoWinnerException(ERROR_MESSAGE_NO_WINNER));
    }
}