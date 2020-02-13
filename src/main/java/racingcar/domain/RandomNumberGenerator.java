package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(10);
    }

    public List<Integer> generateRandomNumbers(final int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            numbers.add(generateRandomNumber());
        }
        return numbers;
    }
}
