package domain;

import util.Exceptions;

public class Lap {

    private final int count;

    public Lap(int count) {
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
