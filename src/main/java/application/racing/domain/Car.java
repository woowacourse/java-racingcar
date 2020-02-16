package application.racing.domain;

public class Car {
    private CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public void move(int number) {
        this.position.move(number);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.getPosition() == maxPosition;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public String toString() {
        return this.carName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof Car)) {
            return false;
        }
        Car compareCar = (Car) o;
        return compareCar.carName.equals(this.carName)
                && compareCar.position.equals(this.position);
    }

    @Override
    public int hashCode() {
        return 31 * (this.carName.hashCode() + this.position.hashCode());
    }
}
