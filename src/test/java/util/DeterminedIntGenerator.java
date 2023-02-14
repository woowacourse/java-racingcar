package util;

import java.util.Random;
import racingcar.util.IntGenerator;

public class DeterminedIntGenerator implements IntGenerator {

    private final int determinedNumber;

    public DeterminedIntGenerator(int determinedNumber) {
        this.determinedNumber = determinedNumber;
    }

    public int getByRange(int min, int max) {
        return determinedNumber;
    }
}
