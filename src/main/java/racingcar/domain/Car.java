package racingcar.domain;

import racingcar.utils.numbergenerator.NumberGenerator;

public class Car {

    private static final int MIN_GO_FORWARD_RANGE = 4;

    private final NumberGenerator numberGenerator;
    private final Name name;
    private int position;

    public Car(final String name, final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = new Name(name);
        position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        if (numberGenerator.generate() >= MIN_GO_FORWARD_RANGE) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car("
                + "name = " + name
                + ", position = " + position
                + ")";
    }
}
