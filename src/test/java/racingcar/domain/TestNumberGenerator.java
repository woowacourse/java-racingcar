package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class TestNumberGenerator implements NumberGenerator {

    private final Queue<Integer> testNumbers;

    public TestNumberGenerator(List<Integer> testNumbers) {
        this.testNumbers = new LinkedList<>(testNumbers);
    }

    @Override
    public int generate() {
        return testNumbers.remove();
    }

}
