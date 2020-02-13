package racingcargame.domain;

public class Repeat {

    private static final int ZERO = 0;

    private int repeat;

    public Repeat(int repeat) {
        validateNegative(repeat);
        this.repeat = repeat;
    }

    private void validateNegative(int repeat) {
        if (repeat < ZERO) {
            throw new IllegalArgumentException("반복 횟수는 음수가 될 수 없습니다.");
        }
    }

    public int getRepeat() {
        return repeat;
    }
}
