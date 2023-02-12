package racingcar.service;

import java.util.List;
import java.util.Map;

import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.GameStatusChecker;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.ValueGenerator;

public class RacingService {

    private final Cars cars;
    private final ValueGenerator valueGenerator;
    private GameStatusChecker gameStatusChecker;

    public RacingService() {
        this.cars = new Cars();
        this.valueGenerator = new RandomValueGenerator();
    }

    public void makeCars(String carNames) {
        for (String name : new CarNames(carNames).getNames()) {
            cars.add(new Car(name));
        }
    }

    public void setNumberOfRounds(int numberOfRounds) {
        gameStatusChecker = new GameStatusChecker(numberOfRounds);
    }

    public boolean isOngoing() {
        return gameStatusChecker.isOngoing(cars.getTurnCount());
    }

    public void playRound() {
        cars.playRound(valueGenerator);
    }

    public Map<String, Integer> getCurrentRoundResult() {
        return cars.getRoundResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}

