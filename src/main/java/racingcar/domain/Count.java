package racingcar.domain;

public class Count {
    private static final int NEGATIVE_NUMBER_STANDARD = 0;
    private static final int COUNT_SUBTRACT_POSSIBLE_STANDARD = 0;

    private int count;

    public Count(String input) {
        int number = Integer.parseInt(input);
        validateNegative(number);
        this.count = number;
    }

    private void validateNegative(int number) {
        if (number < NEGATIVE_NUMBER_STANDARD) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasNextCount() {
        if (count > COUNT_SUBTRACT_POSSIBLE_STANDARD) {
            count--;
            return true;
        }
        return false;
    }
}
