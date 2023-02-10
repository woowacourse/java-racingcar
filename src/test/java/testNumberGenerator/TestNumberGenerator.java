package testNumberGenerator;

import java.util.Iterator;
import java.util.List;

import utils.numberGenerator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private final Iterator<Integer> testNumber;

    public TestNumberGenerator(List<Integer> testNumber) {
        this.testNumber = testNumber.iterator();
    }

    @Override
    public int generateNumber() {
        while (testNumber.hasNext()) {
            return testNumber.next();
        }

        throw new IllegalArgumentException();
    }
}
