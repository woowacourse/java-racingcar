package racingCar.dto;

import racingCar.domain.CarName;
import racingCar.domain.Position;

public class CarDto {

    private static final String POSITION_MARK = "-";

    private final CarName name;
    private final Position position;

    public CarDto(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " : " + POSITION_MARK.repeat(position.getPosition()));
        return stringBuilder.toString();
    }
}
