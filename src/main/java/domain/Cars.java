package domain;

import java.util.List;


public class Cars {
    private List<Car> cars;
    private final CarAccelerator accelerator;

    public Cars(List<Car> cars, CarAccelerator accelerator) {
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
            throw new IllegalArgumentException();
        }
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public void tryMove() {
        for (Car car : cars) {
            car.moveForward(car.pushAccelerator());
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
