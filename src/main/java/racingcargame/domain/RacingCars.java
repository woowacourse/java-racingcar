package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void go() {
        cars.forEach(car -> car.go(Engine.createRandomEngine()));
    }

    public String printPosition() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.printPosition());
        }
        return sb.toString();
    }

    public List<Car> extractWinners() {
        Collections.sort(cars);
        Car firstScoreCar = cars.get(cars.size() - 1);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSameToPosition(firstScoreCar))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }
}
