package racingcar.domain.car;

import racingcar.dto.CarPerformance;
import racingcar.exception.InvalidCarNameLengthException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int REQUIRED_OIL = 4;

    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new InvalidCarNameLengthException();
        }
    }

    public void goIfOilEnough(int oil) {
        if (oil >= REQUIRED_OIL) {
            movedDistance++;
        }
    }

    public CarPerformance getCurrentPerformance() {
        return new CarPerformance(name, movedDistance);
    }

    public boolean isSameDistance(int distance) {
        return distance == movedDistance;
    }
}
