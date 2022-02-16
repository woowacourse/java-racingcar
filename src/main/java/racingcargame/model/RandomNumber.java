package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber {
    private List<Integer> numbers;

    private RandomNumber(int start, int end) {
        numbers = IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static RandomNumber of(int start, int end) {
        return new RandomNumber(start, end);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
