package racingcar.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    public List<Integer> generate(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> random.nextInt(10))
                .toList();
    }

    public int generate() {
        return random.nextInt(10);
    }
}
