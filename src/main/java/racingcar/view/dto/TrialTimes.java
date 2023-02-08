package racingcar.view.dto;

public class TrialTimes {
    private final Integer trialTimes;

    public TrialTimes(String trialTimes) {
        validate(trialTimes);
        this.trialTimes = Integer.parseInt(trialTimes);
    }

    private void validate(String trialTimes) {
        validateNumber(trialTimes);
    }

    private void validateNumber(String trialTimes) {
        try {
            int number = Integer.parseInt(trialTimes);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수만 입력 가능합니다.");
        }
    }

}
