package racingGame.domain.racingCar;

public class Car {
    private static final int MINIMUM_TO_MOVE = 4;

    private final Name name;
    private int position = 0;

    public Car(final Name name) {
        this(name, 0);
    }

    public Car(final Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createByName(final Name name) {
        return new Car(name);
    }

    public Name getName() {
        return name;
    }

    public boolean isOnPosition(int position) {
        return position == this.position;
    }

    public void tryToMove(int number) {
        if (number >= MINIMUM_TO_MOVE) {
            position++;
        }
    }

    public CarDto getStatus() {
        return new CarDto(name, position);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Car) {
            return this.name.equals(((Car) o).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}