package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Position;

public class CarDto {
    private final String name;
    private Position position;

    public CarDto(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getPositionAsInt() {
        return position.getPosition();
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}