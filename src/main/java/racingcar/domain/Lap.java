package racingcar.domain;

public class Lap {
    private final int totalLap;
    private int countTryLap;

    public Lap(int totalLap) {
        validateRange(totalLap);
        this.totalLap = totalLap;
        this.countTryLap = 0;
    }

    public void run() {
        this.countTryLap = this.countTryLap + 1;
    }

    public boolean isNotSame() {
        return countTryLap == totalLap;
    }

    public int getCountTryLap() {
        return this.countTryLap;
    }

    private void validateRange(int totalLap) {
        if (totalLap < 0) {
            throw new IllegalArgumentException("0이상의 숫자만 입력 가능합니다.");
        }
    }
}
