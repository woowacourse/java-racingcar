package domain;

public class FakeNumber implements Number {
    private final int number;

    public FakeNumber(int number) {
        this.number = number;
    }

    @Override
    public int get() {
        return number;
    }
}
