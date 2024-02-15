package domain;

import java.util.Arrays;

public class Validator {

    private Validator() {
    }

    public static void validateCarName(String name) {
        if (!name.matches("^[a-zA-Z가-힣]{1,5}$")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCount(int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateParticipant(String[] carNames) {
        validateAmount(carNames);
        validateDuplicated(carNames);
    }

    private static void validateAmount(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicated(String[] carNames) {
        long uniqueCount = Arrays.stream(carNames)
                .distinct()
                .count();
        if (uniqueCount != carNames.length) {
            throw new IllegalArgumentException();
        }
    }
}
