package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public Cars generate(String input) {
        String[] split = input.split(",");
        return new Cars(createNames(split));
    }

    private List<Name> createNames(String[] split) {
        return Arrays.stream(split)
            .map(Name::of)
            .collect(Collectors.toList());
    }
}
