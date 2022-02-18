package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    private static final int RANDOM_BOUND = 10;

    public static int getNumber() {
        return ThreadLocalRandom.current().nextInt(RANDOM_BOUND);
    }

    public static List<Integer> getNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(RANDOM_BOUND));
        }
        return numbers;
    }
}
