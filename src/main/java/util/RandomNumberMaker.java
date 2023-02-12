package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberMaker {
    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static List<Integer> makeNumber(int CarSize) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < CarSize; i++) {
            randomNumbers.add(random.nextInt(BOUND));
        }
        return randomNumbers;
    }
}
