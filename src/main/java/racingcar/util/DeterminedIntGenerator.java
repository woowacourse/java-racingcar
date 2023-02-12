package racingcar.util;

import java.util.Random;

public class DeterminedIntGenerator implements IntGenerator {

    private final int determinedNumber;

    public DeterminedIntGenerator(int determinedNumber) {
        this.determinedNumber = determinedNumber;
    }

    public int getByRange(int min, int max) {
        return determinedNumber;
    }
}
