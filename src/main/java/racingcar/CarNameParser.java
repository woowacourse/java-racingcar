package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public List<String> parse(String names) {
        validateCarNames(names);

        return Arrays.stream(splitByComma(names))
            .collect(toList());
    }

    private void validateCarNames(String names) {
        if (isInvalidLength(names)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private boolean isInvalidLength(String names) {
        return Arrays.stream(splitByComma(names))
            .anyMatch(n -> n.length() > 5);
    }

    private String[] splitByComma(String names) {
        return names.split(",");
    }
}
