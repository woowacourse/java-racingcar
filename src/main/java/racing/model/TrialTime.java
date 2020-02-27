package racing.model;

public class TrialTime {
    private int trialTime;

    public TrialTime(final String trialTime) {
        checkTrialTimeNull(trialTime);
        checkTrialTimeEmpty(trialTime);
        checkTrialTimeNotNumber(trialTime);
        checkTrialTimeNegativeOrZero(trialTime);
        this.trialTime = Integer.parseInt(trialTime);
    }

    private void checkTrialTimeNotNumber(final String trialTime) {
        try {
            Integer.parseInt(trialTime);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("시도횟수는 정수를 입력해주세요.");
        }
    }

    private void checkTrialTimeNull(final String trialTime) {
        if (trialTime == null) {
            throw new NullPointerException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private void checkTrialTimeEmpty(final String trialTime) {
        if (trialTime.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private void checkTrialTimeNegativeOrZero(final String trialTime) {
        int trialTimeIntegerValue = Integer.parseInt(trialTime);
        if (trialTimeIntegerValue <= 0) {
            throw new IllegalArgumentException("시도횟수는 음수가 입력될 수 없습니다.");
        }
    }

    public int getTrialTime() {
        return trialTime;
    }
}
