package domain;

import java.util.List;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        validateCarsSize(cars);
        validateCarsDuplication(cars);
        this.cars = cars;
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException("이름을 2개 이상 입력하세요.");
        }
    }

    private void validateCarsDuplication(List<Car> cars) {
        long uniqueCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (uniqueCount != cars.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(car -> car.move(RandomGenerator.getRandomNumber()));
    }
}
