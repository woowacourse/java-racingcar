package racingcar.domain;

public class MockFixedNumberGenerator implements NumberGenerator {
    private int returnNumber;

    public MockFixedNumberGenerator(int returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public int generate(int minNumber, int maxNumber) {
        return returnNumber;
    }
}
