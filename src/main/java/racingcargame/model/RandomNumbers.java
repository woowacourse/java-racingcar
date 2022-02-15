package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final List<Integer> numbers;

    private RandomNumbers(int start, int end) {
        this.numbers = IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static RandomNumbers of(int start, int end) {
        return new RandomNumbers(start, end);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
