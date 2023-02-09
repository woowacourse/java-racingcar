package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberMaker {
    private static final int BOUND = 9;

    public List<Integer> makeNumber(int CarSize) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < CarSize; i++) {
            randomNumbers.add(random.nextInt(BOUND));
        }
        return randomNumbers;
    }
}
