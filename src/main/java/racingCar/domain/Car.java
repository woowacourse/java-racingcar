package racingCar.domain;

import racingCar.dto.CarDto;

public class Car {

    private static final int MOVE_MIN_NUM = 4;

    private CarName name;
    private Position position;

    public Car(String carName) {
        name = new CarName(carName);
        position = new Position();
    }

    public void move(int pickedNumber) {
        if (pickedNumber >= MOVE_MIN_NUM) {
            position.increase();
        }
    }

    public boolean isSamePosition(int other) {
        return position.getPosition() == other;
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
