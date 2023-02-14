package racingcar.domain;

public class Car {

    private static final int BOUNDARY = 4;

    private final CarName carName;
    private final Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }


    public void move(int number) {
        if (number >= BOUNDARY) {
            this.position.move();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
