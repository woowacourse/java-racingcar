package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_POSITION = 0;
    private static final String JOIN_BY_COMMA = ", ";

    private final NumberGenerator randomNumber = new RandomNumberGenerator();
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validateCarNames(cars);
    }

    private void validateCarNames(List<Car> cars) {
        int countDistinctNames = (int) cars.stream()
                .map(Car::getName)
                .map(Name::getName)
                .distinct()
                .count();

        if (countDistinctNames != cars.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 존재할 수 없습니다.");
        }
    }

    public void moveAll() {
        cars.forEach(car -> car.move(randomNumber));
    }

    public int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(position -> position)
                .max().orElse(MINIMUM_POSITION);
    }

    public String findWinnerName(int maxPosition) {
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.joining(JOIN_BY_COMMA));
    }

    public List<Car> getCars() {
        return cars;
    }
}
