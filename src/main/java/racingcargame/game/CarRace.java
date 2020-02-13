package racingcargame.game;

import racingcargame.domain.Car;
import racingcargame.domain.TrialTimes;
import racingcargame.genrator.RandomGenerator;
import racingcargame.view.output.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarRace {

    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private final List<Car> cars;

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

    public void run(TrialTimes trialTimes) {
        for (int i = 0; i < trialTimes.getTrialTimes(); i++) {
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

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
