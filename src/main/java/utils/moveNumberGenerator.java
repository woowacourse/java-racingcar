package utils;

import java.util.ArrayList;
import java.util.List;

public class moveNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate(int count, int endInclusive) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(4);
        }

        return randomNumbers;
    }
}
