package racingcar.util;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomRefuelGenerator implements RefuelGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public List<Integer> generate(final int max, final int total) {
        return IntStream.rangeClosed(1, total)
                .mapToObj(i -> RANDOM.nextInt(max + 1)) // bound 미만의 숫자를 return하기 때문에 +1
                .toList();
    }
}
