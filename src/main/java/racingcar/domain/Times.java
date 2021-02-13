package racingcar.domain;

public class Times {
    private static final int ZERO = 0;
    private static final int TIMES_LIMITATION = (int) 1e8;
    private static final String ERROR = "[ERROR] ";
    private static final String NON_POSITIVE_ERROR = ERROR + "양수만 입력해 주세요.";
    private static final String LIMITATION_ERROR = ERROR + "한계값 이하만 입력해 주세요.";

    private int times;

    public Times(int times) {
        validate(times);
        this.times = times;
    }

    private void validate(int times) {
        validatePositive(times);
        validateLimitation(times);
    }

    private void validatePositive(int times) {
        if (times <= ZERO) {
            throw new IllegalArgumentException(NON_POSITIVE_ERROR);
        }
    }

    private void validateLimitation(int times) {
        if (times <= TIMES_LIMITATION) {
            return;
        }
        throw new IllegalArgumentException(LIMITATION_ERROR);
    }

    public void reduce() {
        times--;
    }

    public boolean hasTurn() {
        return times != ZERO;
    }
}
