package racingcar.domain;

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

    public int getPosition() {
        return position.getMoveCount();
    }

    public String getCarName() {
        return carName.getName();
    }
}
