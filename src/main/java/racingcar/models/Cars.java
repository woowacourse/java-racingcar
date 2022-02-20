package racingcar.models;

import racingcar.utils.RandomNumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startOneTurn() {
        cars.forEach(car -> {
            int randomNumber = RandomNumber.getRandomNumber();
            car.goForward(randomNumber);
        });
    }

    public List<String> findWinners() {
        final int farthestPosition = findFarthestPosition();
        return getWinners(farthestPosition);
    }

    private int findFarthestPosition() {
        final List<Integer> sortedCars = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .map(Car::getPosition)
                .collect(Collectors.toList());

        if (!sortedCars.isEmpty()) {
            return sortedCars.get(0);
        }
        return 0;
    }

    private List<String> getWinners(final int farthestPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(farthestPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
