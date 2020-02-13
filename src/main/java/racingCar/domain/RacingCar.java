package racingCar.domain;

import racingCar.domain.errors.InvalidInputException;

public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        if (5 < name.length()) {
            throw new InvalidInputException();
        }
        this.name = name;
    }

    public int getPostion() {
        return position;
    }

    public void go() {
        position++;
    }

    public void stop() {

    }

    public void goManyTimes(int givenNumberToGo) {
        for (int i = 0; i < givenNumberToGo; i++) {
            go();
        }
    }

    public void stopManyTimes(int givenNumberToStop) {
        for (int i = 0; i < givenNumberToStop; i++) {
            stop();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void goWithNumberOverFour(int i) {
        go();
    }

    public void stopWithNumberUnderThree(int i) {
        stop();
    }
}
