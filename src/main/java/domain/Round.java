package domain;

import util.Exceptions;

public class Round {

    private final int count;

    public Round(int count) {
        validateInvalidCount(count);
        this.count = count;
    }

    private void validateInvalidCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Exceptions.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public int getCount() {
        return count;
    }

}
