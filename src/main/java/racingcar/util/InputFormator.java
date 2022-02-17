package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.car.Name;

public class InputFormator {
    private static final String INPUT_DELIMITER = ",";
    private static final int SPLIT_INPUT_EMPTY_VALUE = 0;

    public static List<Name> toNameList(String input) {
        String[] splitInput = input.split(INPUT_DELIMITER);
        validateSplitInput(splitInput);
        return Arrays.stream(splitInput)
            .map(name -> new Name(name))
            .collect(Collectors.toList());
    }

    private static void validateSplitInput(String[] splitInput) {
        if (splitInput.length == SPLIT_INPUT_EMPTY_VALUE) {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        }
        long removeDuplicateSize = Arrays.stream(splitInput)
            .distinct()
            .count();
        if (removeDuplicateSize != splitInput.length) {
            throw new IllegalArgumentException("중복된 이름을 가지고 있습니다.");
        }
    }
}
