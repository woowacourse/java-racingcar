package utils;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generateOneDigitRandomNumbers(int carNumbers) {
        List<Integer> oneDigitRandomNumbers = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            oneDigitRandomNumbers.add((int) (Math.random() * 10));
        }
        return oneDigitRandomNumbers;
    }
}
