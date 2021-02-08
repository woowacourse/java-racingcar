package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class RacingGame {

    private final List<Car> cars;
    private final int trial;
    private int currentTrial = 0;

    public RacingGame(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public void tryToMove() {
        for (Car car : cars) {
            int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
        }
        currentTrial++;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findCarNamesLocatedAt(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream().map(Car::getPosition).reduce(Integer::max).orElse(-1);
    }

    private List<String> findCarNamesLocatedAt(int position) {
        return cars.stream().filter(car -> car.getPosition() == position).map(Car::getName).collect(
            Collectors.toList());
    }

    public boolean isFinished() {
        return currentTrial >= trial;
    }

    public List<Car> getCars() {
        return cars;
    }
}
