package racingcar.model;

import java.util.List;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars, int maxPosition) {
        this.cars = cars;
        validateWinner(cars, maxPosition);
    }

    private void validateWinner(List<Car> cars, int maxPosition) {
        if (!cars.stream()
                .allMatch(car -> car.getPosition() == maxPosition)) {
            throw new IllegalArgumentException("우승자 판별이 잘못 계산되었습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
