package racingCar.dto;

import racingCar.domain.Position;

public class CarDto {
    private final String name;
    private final Position position;

    public CarDto(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
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
