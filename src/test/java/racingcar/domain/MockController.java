package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockController {

    public static List<String> extractCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

}
