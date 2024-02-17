package domain;

import util.Exceptions;

public class Rap {

    private final int count;

    public Rap(int count) {
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
