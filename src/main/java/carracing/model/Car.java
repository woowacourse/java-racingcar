package carracing.model;

import carracing.dto.CarDto;
import carracing.utils.MoveStrategy;

import static carracing.view.messages.ExceptionMessage.*;

public class Car {
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
}
