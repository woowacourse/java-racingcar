package racingcar.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {
    private final List<Car> cars;

    private WinnerCars(List<Car> cars) {
        this.cars = cars;
    }

    public static WinnerCars fromCars(Cars cars) {
        List<Car> playingCars = cars.getCars();
        int maxPosition = calculateWinningPosition(playingCars);

        return new WinnerCars(playingCars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private static int calculateWinningPosition(List<Car> playingCars) {
        return Collections.max(playingCars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
