package racingcar.domain.car;

public class Car {
    private final CarName name;

    public Car(final String name) {
        this.name = new CarName(name);
    }

    public String getName() {
        return name.getName();
    }
}