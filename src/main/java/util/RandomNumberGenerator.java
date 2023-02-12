package util;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements BoundaryNumberGenerator{
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;

    @Override
    public List<Integer> generateBoundaryNumbers(int carsCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int index = 0; index < carsCount; index++) {
            randomNumbers.add((int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER));
        }
        return randomNumbers;
    }
}
