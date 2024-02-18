package mock;

import util.NumberGenerator;

import java.util.List;

public class SequenceNumberGenerator implements NumberGenerator {
    List<Integer> mockingList = List.of(4, 7, 9, 3, 1, 6, 6, 7, 8);
    Integer index = 0;

    @Override
    public int generate() {
        return mockingList.get(index++);
    }
}
