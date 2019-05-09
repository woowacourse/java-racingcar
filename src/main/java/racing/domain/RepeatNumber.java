package racing.domain;

public class RepeatNumber {
    private int repeatNumber;

    public RepeatNumber(int repeatNumber) {
        if (repeatNumber <= 0)
            throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
        this.repeatNumber = repeatNumber;
    }

    public RepeatNumber(String repeatNumber) {
        this(Integer.parseInt(repeatNumber));
    }

    public int getRepeatNumber() {
        return repeatNumber;
    }
}
