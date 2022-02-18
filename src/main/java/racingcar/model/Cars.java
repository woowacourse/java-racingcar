package racingcar.model;

import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validateCarNames(cars);
    }

    private void validateCarNames(List<Car> cars) {
        int countDistinctNames = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (countDistinctNames != cars.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 존재할 수 없습니다.");
        }
    }

    public void moveAll(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            int number = numberGenerator.generate();
            car.move(number);
        });
    }

    public int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(position -> position)
                .max().orElse(MINIMUM_POSITION);
    }

    public List<Car> findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
