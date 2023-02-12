package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.FinalRoundChecker;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.ValueGenerator;

import java.util.List;
import java.util.Map;

public class RacingCarService {

    private final Cars cars;
    private FinalRoundChecker finalRoundChecker;


    public RacingCarService() {
        this.cars = new Cars();
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
        ValueGenerator randomValueGenerator = new RandomValueGenerator();

        do {
            int value = randomValueGenerator.generate();
            cars.addNextCarValue(value);
        } while (!cars.isRoundOver());
    }

    public Map<String, Integer> getCurrentRoundResult() {
        return cars.getRoundResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}

