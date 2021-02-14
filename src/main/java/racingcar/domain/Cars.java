package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.utils.RandomUtils;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomUtils.nextInt());
        }
    }

    public List<Car> getWinners() {
        final int maxPosition = findWinnerPosition();
        final List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }
        return winners;
    }

    private int findWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void addWinner(Car car, int maxPosition, List<Car> winners) {
        if (car.isEqualPosition(maxPosition)) {
            winners.add(car);
        }
    }
}