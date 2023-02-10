package racingCar.domain;

import racingCar.dto.CarDto;

public class Car implements Comparable<Car> {

    private static final int MOVE_MIN_NUM  = 4;
    private static final int NAME_MAX_LENGTH = 5;

    private String name;
    private Position position;

    public Car(String carName) {
        validateLength(carName);
        this.name = carName;
        position = new Position();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    public void move(int pickedNumber) {
        if (pickedNumber >= MOVE_MIN_NUM) {
            position.increase();
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public int compareTo(Car another) {
        return position.compareTo(another.position);
    }

    public CarDto toDto() {
        return new CarDto(this.name, this.position);
    }

}
