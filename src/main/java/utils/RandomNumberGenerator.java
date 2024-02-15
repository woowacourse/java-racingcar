package utils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generate(int carNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            randomNumbers.add((int) (Math.random() * 10));
        }
        return randomNumbers;
    }
}
