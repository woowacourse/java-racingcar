package racingcar.domain;

import racingcar.dto.CarPositionDto;

class Car {

    private static final int GO = 4;

    private final CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        position = Position.init();
    }

    public void move(int power) {
        if (power >= GO) {
            position = position.next();
        }
    }

    public CarPositionDto toDto() {
        return new CarPositionDto(position.getMoveCount(), carName.getName());
    }

    public int getPosition() {
        return position.getMoveCount();
    }

    public boolean matchPosition(int position) {
        return this.position.isMatchMoveCount(position);
    }

    public String getCarName() {
        return carName.getName();
    }
}
