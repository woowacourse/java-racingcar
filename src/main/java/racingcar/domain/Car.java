package racingcar.domain;

import racingcar.util.IntGenerator;

public class Car {

    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String WRONG_LENGTH_OF_NAME_ANNOUNCEMENT = "[ERROR] 잘못된 이름 길이입니다.";

    private final String name;
    private int movedCount;
    private final IntGenerator intGenerator;

    public Car(String name, IntGenerator intGenerator) {
        validateName(name);
        this.name = name;
        this.movedCount = 0;
        this.intGenerator = intGenerator;
    }

    public void tryMove() {
        if (canMove()) {
            this.movedCount++;
        }
    }

    private boolean canMove() {
        return intGenerator.getOneNumber() >= MINIMUM_NUMBER_TO_MOVE;
    }

    private void validateName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < trimmedName.length()) {
            throw new IllegalArgumentException(WRONG_LENGTH_OF_NAME_ANNOUNCEMENT);
        }
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }

}
