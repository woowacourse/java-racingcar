package racingcar.model;

import java.util.List;

public class WinnerCars {
    private final List<Car> cars;

    public WinnerCars(List<Car> cars, int maxPosition) {
        this.cars = cars;
        validateWinnerCars(maxPosition);
    }

    private void validateWinnerCars(int maxPosition) {
        if (!isWinner(maxPosition)) {
            throw new IllegalArgumentException("우승자 판별이 잘못되었습니다.");
        }
    }

    private boolean isWinner(int maxPosition) {
        return this.cars.stream()
                .allMatch(car -> car.isSamePosition(maxPosition));
    }

    public List<Car> getCars() {
        return cars;
    }
}
