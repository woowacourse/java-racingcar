package domain.race;

import domain.car.Car;

import java.util.List;

public class RaceResult {
    private final List<Car> winnerCars;

    public static RaceResult from(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        List<Car> winnerCars = selectWinnerCars(cars, maxPosition);
        return new RaceResult(winnerCars);
    }

    private static Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static List<Car> selectWinnerCars(List<Car> cars, Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .toList();
    }

    private RaceResult(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
