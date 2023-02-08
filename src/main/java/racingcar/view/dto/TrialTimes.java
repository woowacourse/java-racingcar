package racingcar.view.dto;

public class TrialTimes {
    private final Integer trialTimes;

    public TrialTimes(String trialTimes) {
        validate(trialTimes);
        this.trialTimes = Integer.parseInt(trialTimes);
    }

    private void validate(String trialTimes) {
        validateNumber(trialTimes);
        validateRange(trialTimes);
    }

    private void validateNumber(String trialTimes) {
        try {
            int number = Integer.parseInt(trialTimes);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수만 입력 가능합니다.");
        }
    }
    
    private void validateRange(String trialTimes) {
        int trialTimesNumber = Integer.parseInt(trialTimes);

        isOverMaxRange(trialTimesNumber);
        isUnderMinRange(trialTimesNumber);
    }

    private void isOverMaxRange(int trialTimesNumber) {
        if (trialTimesNumber > 100) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 100 이하여야 합니다.");
        }
    }

    private void isUnderMinRange(int trialTimesNumber) {
        if (trialTimesNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 1 이상이어야 합니다.");
        }
    }


}
