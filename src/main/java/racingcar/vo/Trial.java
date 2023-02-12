package racingcar.vo;

import racingcar.util.Validator;

public class Trial {
    private final int trial;
    private int spentTime = 0;

    public Trial(String trial) {
        int parsedTrial = Validator.validateGameTime(trial);
        this.trial = parsedTrial;
    }

    public boolean ieLeft() {
        return trial != spentTime;
    }

    public void useOneTime() {
        spentTime++;
    }

}
