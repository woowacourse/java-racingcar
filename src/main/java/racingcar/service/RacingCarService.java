package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.FinalRoundChecker;
import racingcar.domain.RandomValueGenerator;
import racingcar.domain.Rule;
import racingcar.domain.ValueGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarService {

    private Cars cars;
    private FinalRoundChecker finalRoundChecker;


    public void makeCars(String carNames) {
        cars = new Cars(List.copyOf(
                new CarNames(carNames).getNames()
                        .stream()
                        .map(name -> new Car(name))
                        .collect(Collectors.toUnmodifiableList())
        ));

    }

    public void setNumberOfRounds(int numberOfRounds) {
        finalRoundChecker = new FinalRoundChecker(numberOfRounds);
    }

    public boolean isEnd() {
        return finalRoundChecker.isFinal(cars.getCurrentRound());
    }

    public void playRound() {
        ValueGenerator randomValueGenerator = new RandomValueGenerator();

        do {
            int power = randomValueGenerator.generate();
            cars.moveNextCarWith(power, Rule.MOVING_FORWARD_STANDARD);
        } while (!cars.isRoundOver());
    }

    public Map<String, Integer> getCurrentRoundResult() {
        return cars.getRoundResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}

