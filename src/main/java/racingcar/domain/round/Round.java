package racingcar.domain.round;

import racingcar.domain.round.validator.RoundValidator;

public class Round {

    private int count;

    public Round(final int count) {
        RoundValidator.validateCount(count);
        this.count = count;
    }

    public boolean isNotFinished() {
        return this.count != 0;
    }

    public void decreaseCount() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

}
