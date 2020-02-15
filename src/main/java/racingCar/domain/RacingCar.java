package racingCar.domain;

import racingCar.domain.errors.InvalidInputException;

public class RacingCar implements Comparable<RacingCar> {
    private static final int MAX_RACINGCAR_NAME_LENGTH = 5;
    private static final int STANDARD_TO_GO = 4;
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        if (MAX_RACINGCAR_NAME_LENGTH < name.length()) {
            throw new InvalidInputException(String.format("이름은 최대 길이인 %d를 넘을 수 없습니다.", MAX_RACINGCAR_NAME_LENGTH));
        }
        this.name = name;
    }

    public int getPostion() {
        return position;
    }

    public void go() {
        position++;
    }

    public void goManyTimesAsRandom(int givenNumberToGo, int randomNumber) {
        for (int i = 0; i < givenNumberToGo; i++) {
            go();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void goWithNumberOverFour(int i) {
        if (STANDARD_TO_GO <= i) {
            go();
        }

    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(RacingCar o) {
        if (o.position < this.position) {
            return 1;
        }

        if (o.position == this.position) {
            return 1;
        }

        return -1;
    }
}
