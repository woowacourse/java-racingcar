package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Position position;
    private final GasTank gasTank;

    private Car(final String name) {
        this(new Name(name), new Position(), new GasTank());
    }

    public Car(Name name, Position position, GasTank gasTank) {
        this.name = name;
        this.position = position;
        this.gasTank = gasTank;
    }

    public static Car enrollWithName(final String name) {
        return new Car(name);
    }

    public Car fillUpGas(final int gas) {
        return new Car(name, position, gasTank.fillUp(gas));
    }

    public Car forward() {
        if (gasTank.isEnough()) {
            return new Car(name, position.forward(), gasTank);
        }
        return new Car(name, position, gasTank);
    }

    public Position getMaxPosition(Position position) {
        return position.getMaxPosition(position);
    }

    public boolean isWinner(int maxPosition) {
        return position.equals(new Position(maxPosition));
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
            Objects.equals(position, car.position) &&
            Objects.equals(gasTank, car.gasTank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, gasTank);
    }
}
