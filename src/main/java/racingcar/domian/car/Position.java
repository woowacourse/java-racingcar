package racingcar.domian.car;

import racingcar.domian.RandomNumber;

public class Position {
    private int position;

    Position(int position) {
        this.position = position;
    }

    public void moveByRandom(RandomNumber randomNumber) {
        if(randomNumber.isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

}
