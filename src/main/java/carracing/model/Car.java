package carracing.model;

import carracing.dto.CarDto;
import carracing.utils.MoveStrategy;
import java.util.Objects;

import static carracing.view.messages.ExceptionMessage.*;

public class Car implements Comparable<Car> {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
        this.name = name;
        this.position = 0;
    }

    public CarDto toCarDto() {
        return new CarDto(this.name, this.position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isEqualPositionTo(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
