package racingcar.domain;

import racingcar.utils.Validator;

public class Count {
    private final int count;

   public Count(final int count) {
        Validator.checkCount(count);
        this.count = count;
    }

    public int get() {
        return count;
    }
}
