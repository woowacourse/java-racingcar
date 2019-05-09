package racing.domain;

public class RepeatNumber {
    private int number;

    public RepeatNumber(int number) {
        if (number <= 0)
            throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
        this.number = number;
    }

    public RepeatNumber(String number) {
        this(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }
}
