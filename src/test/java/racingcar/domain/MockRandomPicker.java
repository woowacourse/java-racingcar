package racingcar.domain;

import java.util.List;

public class MockRandomPicker implements NumberPicker {

    private final List<Integer> expected;
    private int pos = 0;


    public MockRandomPicker(List<Integer> expected) {
        this.expected = expected;
    }

    @Override
    public int pickNumber() {
        return expected.get(pos++);
    }
}
