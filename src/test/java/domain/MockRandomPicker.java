package domain;

public class MockRandomPicker implements NumberPicker {
    private int count = 0;

    @Override
    public int pickNumber() {
        count = 1 - count;
        return 3 + count;
    }
}
