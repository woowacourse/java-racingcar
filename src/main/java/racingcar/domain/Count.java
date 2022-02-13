package racingcar.domain;

import racingcar.utils.Validator;

public class Count {
    private final int count;

    public Count(int count) {
        Validator.checkCount(count);
        this.count = count;
    }

    public int getInt() {
        return count;
    }
}
