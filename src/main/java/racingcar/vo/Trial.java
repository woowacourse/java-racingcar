package racingcar.vo;

import racingcar.util.Validator;

public class Trial {
    private final int trial;

    public Trial(String trial) {
        int parsedTrial = Validator.validateGameTime(trial);
        this.trial = parsedTrial;
    }

    public int getTrial() {
        return this.trial;
    }

}
