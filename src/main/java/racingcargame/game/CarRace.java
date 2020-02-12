package racingcargame.game;

import racingcargame.domain.Car;
import racingcargame.genrator.RandomGenerator;
import racingcargame.view.output.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarRace {

    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private List<Car> cars;

    public CarRace(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
        Set<Car> carSet = new HashSet<>(cars);
        if (carSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void run(int trialTime) {
        for (int i = 0; i < trialTime; i++) {
            runOneTurn();
            OutputView.printRound(cars);
        }
    }

    private void runOneTurn() {
        for (Car car : cars) {
            int randomNumber = RandomGenerator.generateRandom();
            car.move(randomNumber);
        }
    }
}
