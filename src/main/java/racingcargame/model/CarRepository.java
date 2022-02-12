package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final int START_POSITION = 0;
    private static final int WINNER_POSITION = 0;

    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        cars = carNames.stream()
                .map(carName -> new Car(carName, START_POSITION))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    void moveCars() {
        cars.forEach(Car::moveCar);
    }

    public List<String> findWinner() {
        cars.sort(Collections.reverseOrder());

        List<String> winnerNames = new ArrayList<>();
        int winnerPosition = cars.get(WINNER_POSITION).getPosition();
        cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .forEach(car -> winnerNames.add(car.getName()));
        return winnerNames;
    }
}
