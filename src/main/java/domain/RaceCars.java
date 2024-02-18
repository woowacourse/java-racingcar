package domain;

import java.util.Collections;
import java.util.List;

public class RaceCars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RaceCars(List<Car> cars, NumberGenerator numberGenerator) {
        validateCarsSize(cars);
        validateCarsDuplication(cars);
        this.cars = cars;
        this.numberGenerator = numberGenerator;
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

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getCarCount() {
        return cars.size();
    }

    public void play() {
        for (Car car : cars) {
            car.move(numberGenerator.getRandom());
        }
    }

    public void sortCarsDes() {
        cars.sort(Collections.reverseOrder());
    }

    public List<Car> getWinners(int maxLocation) {
        return cars.stream()
                .filter(car -> car.getLastLocation() == maxLocation)
                .toList();
    }
}
