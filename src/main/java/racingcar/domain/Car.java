package racingcar.domain;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw INVALID_CAR_NAME.getException();
        }
    }
    
    public void go() {
        if (isGoState()) {
            movedDistance++;
        }
    }

    private boolean isGoState() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
