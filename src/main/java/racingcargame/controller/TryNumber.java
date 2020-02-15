package racingcargame.controller;

public class TryNumber {
    private int tryNumber;

    public TryNumber(int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
        this.tryNumber = tryNumber;
    }

    public boolean isNotZero() {
        return tryNumber != 0;
    }

    public void reduce() {
        tryNumber--;
    }
}
