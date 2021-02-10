package racingcar.domain;

import racingcar.view.RacingCarError;

public class Car {
    private static final int GO_CRITERIA = 4;
    private static final int INITIAL_POSITION = 0;
    private static final int UPPER_LIMIT = 5;
    private String name;
    private int position;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
        position = INITIAL_POSITION;
    }

    private static void checkNameLength(String nameCandidate) {
        checkUpperLimit(nameCandidate);
        checkLowerLimit(nameCandidate);
    }

    private static void checkUpperLimit(String nameCandidate) {
        if (nameCandidate.length() > UPPER_LIMIT) {
            RacingCarError.upperLength();
        }
    }

    private static void checkLowerLimit(String nameCandidate) {
        if (nameCandidate.length() <= 0) {
            RacingCarError.lowerLength();
        }
    }

    public void oneTurn(int randomTurnNumber) {
        if (randomTurnNumber >= GO_CRITERIA) {
            progressPosition();
        }
    }

    private void progressPosition() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}