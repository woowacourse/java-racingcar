package racingcar.model;

public class Car {

    private static final int MIN_NUMBER = 4;
    private final CarName name;
    private int position;

    private Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(new CarName(name), 0);
    }

    public void go(final int number) {
        if (number >= MIN_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
