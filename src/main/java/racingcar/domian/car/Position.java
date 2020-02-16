package racingcar.domian.car;

import racingcar.domian.RandomNumber;

public class Position {
    private int distance;

    Position(int distance) {
        this.distance = distance;
    }

    public void moveByRandom(RandomNumber randomNumber) {
        if(randomNumber.isMovable()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

}
