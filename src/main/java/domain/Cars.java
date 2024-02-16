package domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int MIN_PARTICIPANT = 2;

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

    public int getWinnerLocation() {
        cars.sort(Collections.reverseOrder());
        return cars.get(0).getLocation();
    }

    public List<Car> getWinners(int furthestLocation) {
        return cars.stream()
                .filter(car -> car.getLocation() == furthestLocation)
                .toList();
    }

    private void validateParticipant(List<Car> cars) {
        validateAmount(cars);
        validateDuplicated(cars);
    }

    private void validateAmount(List<Car> cars) {
        if (cars.size() < MIN_PARTICIPANT) {
            throw new IllegalArgumentException("2인 이상의 참가자를 입력해주세요.");
        }
    }

    private void validateDuplicated(List<Car> cars) {
        long uniqueCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (uniqueCount != cars.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
