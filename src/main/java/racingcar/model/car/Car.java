package racingcar.model.car;

import racingcar.model.value.Name;
import racingcar.model.value.Position;
import racingcar.util.NumberGenerator;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int STANDARD_VALUE = 4;

    private final Name name;
    private Position position;

    public Car(String nameString) {
        this.name = new Name(nameString);
        this.position = Position.fromStartLine();
    }

    public void goOrStop(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= STANDARD_VALUE) {
            position = position.move(MOVING_DISTANCE);
        }
    }

    public boolean isSameWith(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

}
