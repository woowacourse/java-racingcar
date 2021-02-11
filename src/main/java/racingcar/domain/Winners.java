package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> cars;
    private final int maxPosition;
    private List<String> winners = new ArrayList<>();

    public Winners(List<Car> cars, int maxPosition) {
        this.cars = cars;
        this.maxPosition = maxPosition;
        findWinner();
    }

    public List<String> getWinners() {
        return winners;
    }

    private void findWinner() {
        winners = cars.stream()
            .filter(car -> isWinner(car))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private boolean isWinner(Car car) {
        return car.isPosition(maxPosition);
    }
}
