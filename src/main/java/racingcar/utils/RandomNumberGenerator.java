package racingcar.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    public static List<Integer> generate(int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .mapToObj(i -> random.nextInt(10))
                .toList();
    }

    public static int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
