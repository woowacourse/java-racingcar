package racingCar.dto;

import racingCar.domain.CarName;
import racingCar.domain.Position;

public class CarDto {

    private final CarName name;
    private final Position position;

    public CarDto(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " : ");
        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
