package racingcar.domain;

public class Round {

    private static final String INVALID_ROUND_RANGE = "시도 횟수는 1 이상 입력해 주세요.";
    private static final String INVALID_ROUND_FORMAT = "시도 횟수는 숫자만 입력해 주세요.";

    private int count;

    public Round(String count) {
        this.count = tryConvertRoundCount(count);
        validateCountRange();
    }

    private void validateCountRange() {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_ROUND_RANGE);
        }
    }

    private int tryConvertRoundCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_FORMAT);
        }
    }

    public boolean isRemain() {
        return count > 0;
    }

    public void decreaseCount() {
        count--;
    }
}
