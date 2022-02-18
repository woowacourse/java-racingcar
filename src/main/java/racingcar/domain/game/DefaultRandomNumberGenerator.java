package racingcar.domain.game;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    private static final int START_INCLUSIVE_NUMBER = 0;
    private static final int END_EXCLUSIVE_NUMBER = 10;

    private final Random random;
    private final List<Integer> numbers;

    public DefaultRandomNumberGenerator() {
        this.random = new Random();
        this.numbers = IntStream.range(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER)
            .boxed()
            .collect(toUnmodifiableList());
    }

    @Override
    public int getRandomNumber() {
        int randomIndex = random.nextInt(numbers.size());
        return numbers.get(randomIndex);
    }
}
