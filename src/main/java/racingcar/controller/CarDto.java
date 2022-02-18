package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;

public class CarDto {
    private final Name name;
    private final Position position;

    public CarDto(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
