package mock;

import util.NumberGenerator;

import java.util.List;

public class SequenceNumberGenerator implements NumberGenerator {
    List<Integer> mockingList;
    Integer index = 0;

    public SequenceNumberGenerator(final List<Integer> mockingList) {
        this.mockingList = mockingList;
    }

    @Override
    public int generate() {
        return mockingList.get(index++);
    }
}
