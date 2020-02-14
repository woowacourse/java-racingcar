package application.racing.domain;

public class Car {
    private CarName carName;
    private Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void moveCar(int number) {
        this.position.move(number);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public String toString() {
        return this.carName.toString();
    }
}
