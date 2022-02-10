package racingcar.model.trycount;

import racingcar.util.NumberValidator;

public class TryCount {
    private final int tryCount;

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(String input) {
        NumberValidator.validateStringIsNumber(input);

        int number = Integer.parseInt(input);
        NumberValidator.validateIsPositive(number);
        return new TryCount(number);
    }
}
