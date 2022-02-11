package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidatorUtils {

    public static int validateAndParsePositiveInt(String string) {
        int integer = Integer.parseInt(string);
        validatePositiveInt(integer);
        return integer;
    }

    private static void validatePositiveInt(int integer) {
        if (integer <= 0) {
            throw new RuntimeException("양수를 입력해야 합니다.");
        }
    }

    public static String[] splitAndValidateCarNames(String carNamesString) {
        String[] carNames = carNamesString.split(",");

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }
        validateNoDuplicates(carNames);

        return carNames;
    }

    private static void validateNotBlank(String string) {
        if (string.trim().isEmpty()) {
            throw new RuntimeException("공백을 입력하면 안 됩니다.");
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > 5) {
            throw new RuntimeException("5글자 이하의 이름을 입력해야 합니다.");
        }
    }

    private static void validateNoDuplicates(String[] strings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(strings));
        if (strings.length != carNameSet.size()) {
            throw new RuntimeException("중복된 이름을 입력하면 안 됩니다.");
        }
    }
}
