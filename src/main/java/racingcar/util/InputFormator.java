package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.car.Name;

public class InputFormator {
    public static List<Name> toNameList(String input) {
        String[] splitInput = input.split(",");
        validateSplitInput(splitInput);
        return Arrays.stream(splitInput)
            .map(name -> new Name(name))
            .collect(Collectors.toList());
    }

    private static void validateSplitInput(String[] splitInput) {
        if (splitInput.length == 0) {
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
