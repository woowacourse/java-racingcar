package racingcar.domain;

public class Lap {
    private static final String NUMERIC_REGULAR_EXPRESSION = "\\d+";
    private static final int MINIMUM_LAP_COUNT = 1;
    private static final String NOT_OVER_ONE_ERROR_MESSAGE = "1 이상의 숫자를 입력하세요.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자를 입력하세요.";

    private int lap;

    public Lap(String lapInput) {
        this.lap = validateLap(lapInput);
    }

    private int validateLap(String lapInput) {
        validateNumeric(lapInput);
        int lap = Integer.parseInt(lapInput);
        validateMinimum(lap);
        return lap;
    }

    private void validateNumeric(String lapInput) {
        if (lapInput.matches(NUMERIC_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateMinimum(int lap) {
        if (lap < MINIMUM_LAP_COUNT) {
            throw new IllegalArgumentException(NOT_OVER_ONE_ERROR_MESSAGE);
        }
    }
}
