package racingcar.domain;

public class Trial {
    private static final int GAME_COUNT_MINIMUM = 1;
    private int trial;

    public Trial(String trial) throws Exception {
        this.trial = isNotNumber(trial);
        isNotPositiveNumber();
    }

    private int isNotNumber(String trial) {
        try {
            return Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도 횟수는 숫자를 입력해주세요.");
        }
    }

    private void isNotPositiveNumber() {
        if (this.trial < GAME_COUNT_MINIMUM) {
            throw new IllegalArgumentException("시도 횟수는 양수만 입력해주세요.");
        }
    }
}
