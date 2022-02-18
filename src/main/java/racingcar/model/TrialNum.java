package racingcar.model;

public class TrialNum {
    private int number;

    public TrialNum(String trialNum) {
        validateTrialNum(trialNum);
        this.number = Integer.parseInt(trialNum);
    }

    public void increase() {
        number++;
    }

    private void validateTrialNum(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
