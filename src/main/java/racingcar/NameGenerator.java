package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameGenerator {
    public List<Name> generate(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split)
            .map(Name::of)
            .collect(Collectors.toList());
    }
}
