package racingcar.model;

import java.util.List;

public class WinnerCars {
    private final List<Car> cars;

    public WinnerCars(List<Car> cars, int maxPosition) {
        this.cars = cars;
        validateWinnerCars(cars, maxPosition);
    }

    private void validateWinnerCars(List<Car> cars, int maxPosition) {
        boolean isWinners = cars.stream().allMatch(car -> car.getPosition() == maxPosition);

        if (!isWinners) {
            throw new IllegalArgumentException("우승자 판별이 잘못되었습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
