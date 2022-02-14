package racingcar.model;

import racingcar.utils.RandomForwardJudgment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forward() {
        cars.forEach(car ->
                car.forward(RandomForwardJudgment.canForward()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int farthestPosition = getFarthestPosition();

        cars.stream()
            .filter(car -> car.isSamePositionWith(farthestPosition))
            .forEach(car -> winners.add(car.getName()));
        return winners;
    }

    private int getFarthestPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElse(-1);
    }
}
