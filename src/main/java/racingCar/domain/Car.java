package racingCar.domain;

import racingCar.dto.CarDto;

public class Car {

    private static final int MIN_POWER = 4;

    private CarName name;
    private Position position;

    public Car(String carName, int initPosition) {
        name = new CarName(carName);
        position = new Position(initPosition);
    }

    public void move(int power) {
        if (power >= MIN_POWER) {
            position.increase();
        }
    }

    public boolean isSamePosition(int otherPosition) {
        return position.getPosition() == otherPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public CarDto toDto() {
        return new CarDto(this.name, this.position);
    }
}
