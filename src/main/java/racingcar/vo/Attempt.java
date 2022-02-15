package racingcar.vo;

public class Attempt {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "시도 회수는 숫자로 입력해야합니다.";
    private static final String NUMBER_NEGATIVE_ERROR_MESSAGE = "시도 회수는 0이상이어야 합니다.";
    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;

    private int attempt;

    public Attempt(String attempt) {
        this.attempt = validate(attempt);
    }

    public int get() {
        return attempt;
    }

    public boolean isLeft() {
        return attempt > EMPTY_COUNT;
    }

    public void decrease() {
        attempt--;
    }

    private int validate(String attempt) {
        validateNumberFormat(attempt);
        int number = toInteger(attempt);
        validateNegative(number);
        return number;
    }

    private int toInteger(String string) {
        return Integer.parseInt(string);
    }

    private void validateNumberFormat(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(NUMBER_NEGATIVE_ERROR_MESSAGE);
        }
    }
}
