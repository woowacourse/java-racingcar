package racingcar.domain.vo;

public class Car implements Comparable<Car> {

    private static final int MOVE_CONDITION = 4;
    private static final int SAME_POSITION = 0;

    private CarName name;
    private Position position;

    public Car(CarName carName) {
        this.name = carName;
        this.position = new Position();
    }

    public CarName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    public boolean isSameName(Car car) {
        return car.name.equals(this.name);
    }

    public boolean isSamePosition(Car car) {
        return position.compareTo(car.position) == SAME_POSITION;
    }

    public void move(int number) {
        if (canMove(number)) {
            position.increase();
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }
}
