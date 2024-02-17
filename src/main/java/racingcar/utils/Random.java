package racingcar.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Random {

    public static int pickNumberInRange(int startInclusive, int endInclusive) {
        List<Integer> numbers = IntStream.rangeClosed(startInclusive, endInclusive).boxed().toList();
        numbers = new ArrayList<>(numbers);
        Collections.shuffle(numbers);
        return numbers.get(0);
    }
}
