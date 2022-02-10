package racingcar;

public class Car {
    private static final int ADVANCE_STANDARD = 4;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void advance(int number) {
        if (number >= ADVANCE_STANDARD) {
            this.position++;
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
