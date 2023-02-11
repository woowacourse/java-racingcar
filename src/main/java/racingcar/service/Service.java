package racingcar.service;

import java.util.List;
import java.util.Map;

import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.FinalRoundChecker;
import racingcar.domain.RandomValueGenerator;

public class Service {

    private final Cars cars;
    private final RandomValueGenerator randomValueGenerator;
    private FinalRoundChecker finalRoundChecker;

    public Service() {
        this.cars = new Cars();
        this.randomValueGenerator = new RandomValueGenerator();
    }

    public void makeCars(String carNames) {
        for (String name : new CarNames(carNames).getNames()) {
            cars.add(new Car(name));
        }
    }

    public void setNumberOfRounds(int numberOfRounds) {
        finalRoundChecker = new FinalRoundChecker(numberOfRounds);
    }

    public boolean isEnd() {
        return finalRoundChecker.isFinal(cars.getTurnCount());
    }

    public void playRound() {
        cars.playRound(randomValueGenerator);
    }

    public Map<String, Integer> getCurrentRoundResult() {
        return cars.getRoundResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}

