package utils;

public class RepeatCount {

    private static final int COUNT_LOWER_BOUND = 0;
    private static final int COUNT_UPPER_BOUND = 100;
    private static final String INVALID_COUNT_MESSAGE = "[ERROR] 시도할 횟수는 1부터 99까지 가능합니다.";
    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 시도할 횟수는 숫자여야 합니다.";

    private int count;

    public RepeatCount(String line) {
        validate(line);
        int count = Integer.parseInt(line);
        validate(count);
        this.count = count;
    }

    public boolean hasNext() {
        return count-- > 0;
    }

    private void validate(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private void validate(int count) {
        if (count > COUNT_LOWER_BOUND && count < COUNT_UPPER_BOUND) {
            return;
        }

        throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
    }
}
