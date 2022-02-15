package racingcar.domain;

public class Count {
    private final static int ZERO = 0;

    private int count;

    public Count(String input) {
        int number = Integer.parseInt(input);
        validateNegative(number);
        this.count = number;
    }

    private void validateNegative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPositive() {
        return count > ZERO;
    }

    public void subtract() {
        count--;
    }
}
