package racingcar.model;

public class Car {

    private static final int MIN_NUMBER = 4;
    private final String name;
    private int position;

    private Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name, 0);
    }

    public void go(final int number) {
        if (number >= MIN_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }
}
