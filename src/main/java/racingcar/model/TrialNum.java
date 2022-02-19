package racingcar.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrialNum trialNum = (TrialNum) o;
        return number == trialNum.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
