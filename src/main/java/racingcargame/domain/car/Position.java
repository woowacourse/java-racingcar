package racingcargame.domain.car;

public class Position {
    public static final int MOVING_CONDITION = 4;
    private int position;

    public int getNumber() {
        return this.position;
    }

    void decideGoOrStop(int num) {
        if (num >= MOVING_CONDITION)
            position++;
    }
}
