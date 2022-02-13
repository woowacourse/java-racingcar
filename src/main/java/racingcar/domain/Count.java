package racingcar.domain;

public class Count {
    private int count;

    public Count(String input) {
        int number = Integer.parseInt(input);
        validateNegative(number);
        this.count = number;
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPositive() {
        return count > 0;
    }

    public void subtract() {
        count--;
    }
}
