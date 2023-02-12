package racingcar.util;

public class DeterminedIntGenerator implements IntGenerator {

    private final int determinedNumber;

    public DeterminedIntGenerator(int determinedNumber) {
        this.determinedNumber = determinedNumber;
    }

    public int getOneNumber() {
        return determinedNumber;
    }
}
