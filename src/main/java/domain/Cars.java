package domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int MIN_PARTICIPANT = 2;
    private static final int WINNER = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateParticipant(cars);
        this.cars = cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.getRandomNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        cars.sort(Collections.reverseOrder());
        int furthestLocation = cars.get(WINNER).getLocation();
        return cars.stream()
                .filter(car -> car.isSameLocation(furthestLocation))
                .toList();
    }

    private void validateParticipant(List<Car> cars) {
        validateAmount(cars);
        validateDuplicated(cars);
    }

    private void validateAmount(List<Car> cars) {
        if (cars.size() < MIN_PARTICIPANT) {
            throw new IllegalArgumentException(ExceptionMessages.PARTICIPANT_AMOUNT);
        }
    }

    private void validateDuplicated(List<Car> cars) {
        long uniqueCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (uniqueCount != cars.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_NAME);
        }
    }
}
