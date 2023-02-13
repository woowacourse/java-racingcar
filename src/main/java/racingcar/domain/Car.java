package racingcar.domain;

public class Car {

    private static final int BOUNDARY = 4;

    private final CarName carName;
    private final Position position;

    public Car(CarName carName) {
        this.carName = new CarName(carName.getCarName());
        this.position = new Position();
    }


    public void move(int number) {
        if (number >= BOUNDARY) {
            this.position.moveForward();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
