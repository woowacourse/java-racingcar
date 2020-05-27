package racing.domain;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    private Car(final String name, final int position) {
        if (name.length() > 5) {
            throw new CarNameLengthOverFiveException();
        }
        if (name.isEmpty()) {
            throw new CarNameEmptyException();
        }

        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int position) {
        if (position < 0) {
            throw new NegativePositionException();
        }
        return new Car(name, position);
    }

    public void move(final int number) {
        if (number < 1 | number > 9) {
            throw new OverRaceNumberRangeException();
        }
        if (number >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
