package racingcar.domain;

import racingcar.util.Converter;
import racingcar.util.Validator;

public class Trial {
    private final int trial;
    private int spentTime = 0;

    public Trial(String parsedTrial) {
        int string = Converter.stringToInt(parsedTrial);
        int trial = Validator.validateGameTime(string);
        this.trial = trial;
    }

    public boolean ieLeft() {
        return trial != spentTime;
    }

    public void useOneTime() {
        spentTime++;
    }

}
