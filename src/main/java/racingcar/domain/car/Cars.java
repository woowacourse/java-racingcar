package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        for (Car car : cars) {
            car.move(moveValueStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(new Position(maxPosition)))
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxPosition() {
        int position = 0;
        for (Car car : cars) {
            position = car.findMaxPosition(new Position(position));
        }
        return position;
    }
}