package racingCar.domain;

import racingCar.dto.CarDto;

public class Car implements Comparable<Car> {
    private static final int MOVE_MIN_NUM  = 4;

    private final CarName name;
    private final Position position;

    public Car(String carName) {
        this.name = new CarName(carName);
        position = new Position();
    }

    public void move(int pickedNumber) {
        if (pickedNumber >= MOVE_MIN_NUM) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public int compareTo(Car another) {
        return position.compareTo(another.position);
    }

    public CarDto toCarDto() {
        return new CarDto(this.name.getCarName(), this.position.getPosition());
    }
}
