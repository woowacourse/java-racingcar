package domain;

public class GameCount {

    private static final String NUMBER_OF_TIME_RANGE_ERROR = "1 ~ 100 사이의 숫자를 입력해주세요";
    private static final String NUMBER_OF_TIME_EXCEED_PROCEED_ERROR = "게임은 횟수만큼만 진행해야합니다.";
    private static final String NON_INTEGER_ERROR = "숫자만 입력 가능합니다.";

    private static final int NUMBER_OF_TIME_LOWER_BOUND_INCLUSIVE = 1;
    private static final int NUMBER_OF_TIME_UPPER_BOUND_INCLUSIVE = 100;
    private static final int NEGATIVE_UPPER_BOUND_EXCLUSIVE = 0;
    private static final int COUNT_NO_MORE = 0;

    private int numberOfTimes;

    public GameCount(String input) {
        int numberOfTimes = validateNumberOfTimesIsNotInteger(input);
        validateRangeOfNumberOfTimes(numberOfTimes);
        this.numberOfTimes = numberOfTimes;
    }

    public void proceedOnce() {
        this.numberOfTimes--;
        validateGameCountIsNegative();
    }

    public boolean isGameProgress() {
        return numberOfTimes != COUNT_NO_MORE;
    }

    private void validateRangeOfNumberOfTimes(int numberOfTimes) {
        if (isNotValidRange(numberOfTimes)) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_RANGE_ERROR);
        }
    }

    private int validateNumberOfTimesIsNotInteger(String numberOfTimes) {
        try {
            return Integer.parseInt(numberOfTimes);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR);
        }
    }

    private void validateGameCountIsNegative() {
        if (numberOfTimes < NEGATIVE_UPPER_BOUND_EXCLUSIVE) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_EXCEED_PROCEED_ERROR);
        }
    }

    private boolean isNotValidRange(int numberOfTimes) {
        return !(NUMBER_OF_TIME_LOWER_BOUND_INCLUSIVE <= numberOfTimes
                && numberOfTimes <= NUMBER_OF_TIME_UPPER_BOUND_INCLUSIVE);
    }

}
