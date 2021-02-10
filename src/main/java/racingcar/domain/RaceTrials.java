package racingcar.domain;

import racingcar.utils.InputValidation;

public class RaceTrials {
    private final int trials;

    public RaceTrials(String trials) {
        InputValidation.validateTrials(trials);
        this.trials = Integer.parseInt(trials);
    }

    public RaceTrials(int trials) {
        this.trials = trials;
    }

    public int getTrials() {
        return this.trials;
    }
}
