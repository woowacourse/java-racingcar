package racingcar.domain;

import racingcar.dto.CarPositionDto;

class Car {

    private final CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        position = Position.init();
    }

    public void move() {
        position = position.next();
    }

    public CarPositionDto toDto() {
        return new CarPositionDto(position.getMoveCount(), carName.getName());
    }

    public int getPosition() {
        return position.getMoveCount();
    }

    public boolean matchPosition(int position) {
        return this.position.getMoveCount() == position;
    }

    public String getCarName() {
        return carName.getName();
    }
}
