package racingcar.domain;

public class Count {
    private static final int NEGATIVE_NUMBER_STANDARD = 0;
    private static final int COUNT_SUBTRACT_POSSIBLE_STANDARD = 0;

    private int count;

    public Count(String input) {
        validateNumberFormat(input);
        int number = Integer.parseInt(input);
        validateNegative(number);
        this.count = number;
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 이외의 값은 불가능합니다.");
        }
    }

    private void validateNegative(int number) {
        if (number < NEGATIVE_NUMBER_STANDARD) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
    }

    public void subtract() {
        if (count <= COUNT_SUBTRACT_POSSIBLE_STANDARD) {
            throw new IllegalStateException();
        }

        count--;
    }
}
