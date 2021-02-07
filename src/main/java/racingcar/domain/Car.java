package racingcar.domain;

import racingcar.utils.RandomUtils;

public class Car {
    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;
    private static final int MINIMUM_TO_MOVE = 4;

    private final Name name;

    private int position = 0;

    private Car(final Name name) {
        this.name = name;
    }

    public static Car createByName(final Name name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isInWinnerPosition(int winnerPosition) {
        return winnerPosition == this.position;
    }

    public void tryToMove() {
        int rand = RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
        if (rand >= MINIMUM_TO_MOVE) {
            movePosition();
        }
    }

    // XXX :: 테스트를 위한 접근 제한자 고민
    private void movePosition() {
        position++;
    }

    private String getPositionBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.name + " : " + getPositionBar();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Car) {
            return this.name.equals(((Car) o).name);
        }
        return false;
    }
}
