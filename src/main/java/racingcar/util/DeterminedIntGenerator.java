package racingcar.util;

import java.util.Random;

public class DeterminedIntGenerator implements IntGenerator {

    private static final String NOT_DETERMINED_NUMBER_ANNOUNCEMENT = "[ERROR] 최솟값과 최댓값이 같아야 합니다.";

    private final int determinedNumber;

    public DeterminedIntGenerator(int determinedNumber) {
        this.determinedNumber = determinedNumber;
    }

    public int getOneNumber(int min, int max) {
        return determinedNumber;
    }
}
