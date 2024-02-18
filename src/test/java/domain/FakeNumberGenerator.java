package domain;

public class FakeNumberGenerator implements NumberGenerator {
    private final int number;

    public FakeNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
