package racingcar.domain.car;

import racingcar.domain.car.vo.CarName;
import racingcar.domain.car.vo.Distance;
import racingcar.dto.CarDto;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int INITIAL_DISTANCE = 0;

    private final CarName carName;
    private final Distance distance;

    public Car(final String carName) {
        this.carName = CarName.valueOf(carName);
        distance = new Distance(INITIAL_DISTANCE);
    }

    public void move(final int movementValue) {
        distance.increaseBy(movementValue);
    }

    public CarDto convertToDto() {
        return new CarDto(carName.getCarName(), distance.getDistance());
    }

    @Override
    public int compareTo(final Car another) {
        if (this.distance.getDistance() > another.distance.getDistance()) {
            return -1;
        } else if (this.distance.getDistance() < another.distance.getDistance()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }
}
