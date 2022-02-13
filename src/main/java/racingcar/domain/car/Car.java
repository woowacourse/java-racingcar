package racingcar.domain.car;

import racingcar.domain.car.vo.CarName;
import racingcar.domain.car.vo.Distance;
import racingcar.dto.CarDto;

import java.util.Objects;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final int INCREASING_UNIT = 1;

    private final CarName carName;
    private final Distance distance;

    public Car(final String carName) {
        this.carName = new CarName(carName);
        distance = new Distance(INITIAL_DISTANCE);
    }

    public void move(final boolean movement) {
        if (movement) {
            distance.increaseBy(INCREASING_UNIT);
        }
    }

    public CarDto info() {
        return new CarDto(carName.getValue(), distance.getValue());
    }

    public boolean isFartherThan(final Car another) {
        return this.distance.isSameOrHigherThan(another.distance);
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
