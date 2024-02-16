package domain;

public class FakeNumberGenerator implements NumberGenerator {
    private final int fakeNumber;

    public FakeNumberGenerator(int fakeNumber) {
        this.fakeNumber = fakeNumber;
    }

    @Override
    public int generateRangeOf(int minRange, int maxRange) {
        return fakeNumber;
    }
}
