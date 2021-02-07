package racingcar.domain;

import racingcar.validator.RoundValidator;
import racingcar.view.InputView;

public class Round {
    private final int count;

    private Round(int count) {
        try {
            RoundValidator.validateRoundCount(count);
        }catch (Exception e) {
            InputView.inputRoundCount();
        }
        this.count = count;
    }

    public static Round of(int count) {
        return new Round(count);
    }

    public int getCount() {
        return this.count;
    }
}
