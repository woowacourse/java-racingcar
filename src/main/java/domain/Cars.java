package domain;

import java.util.List;


public class Cars {
    private final List<Car> cars;
    private final Accelerator accelerator;

    public Cars(List<Car> cars, Accelerator accelerator) {
        validate(cars);
        this.cars = cars;
        this.accelerator = accelerator;
    }

    private void validate(List<Car> cars) {
        validateCarSize(cars);
        validateCarNameDuplication(cars);
    }

    private void validateCarNameDuplication(List<Car> cars) {
        int actualCarAmount = cars.size();
        long distinctCarAmount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (actualCarAmount != distinctCarAmount) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException("자동차 경주를 위해선 2대 이상의 자동차가 필요합니다.");
        }
    }

    public void tryMove() {
        for (Car car : cars) {
            car.moveForward(accelerator);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getWinnerPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }
}
