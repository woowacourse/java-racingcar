package racingcar.model;

public class TrialNum {
    private int value;

    public TrialNum(String trialNum) {
        validateTrialNum(trialNum);
        this.value = Integer.parseInt(trialNum);
    }

    private void validateTrialNum(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }
}
